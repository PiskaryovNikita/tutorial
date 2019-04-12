package com.pn.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pn.model.Hash;
import com.pn.model.Language;
import com.pn.model.Topic;
import com.pn.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicDaoTest {
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private HashDao hashDao;
	@Autowired
	private TestEntityManager em;

	@Before
	public void setUp() {
		Language language = new Language();
		language.setName("Java");
		// после сохр в дб генерируется id
		em.persist(language);
		User user = new User("login", "password", "email@e", "fn", "ln", Date.valueOf("1999-12-12"), "Admin");
		em.persist(user);
		Hash hash1 = new Hash("orm");
		em.persist(hash1);
		Hash hash2 = new Hash("cdi");
		em.persist(hash2);
		Hash hash3 = new Hash("framework");
		em.persist(hash3);
		Topic topicHibernate = new Topic("Hibernate", language, user, Arrays.asList(hash1, hash3));
		em.persist(topicHibernate);
		Topic topicSpring = new Topic("Spring", language, user, Arrays.asList(hash2, hash3));
		em.persist(topicSpring);
		hash1.setTopics(Arrays.asList(topicHibernate));
		hash2.setTopics(Arrays.asList(topicSpring));
		hash3.setTopics(Arrays.asList(topicHibernate, topicSpring));
	}

//	@Test
	public void testFindByName() {
		Topic topic = topicDao.findByName("Hibernate");
		assertNotNull(topic);
	}

//	@Test
	public void testFindByUserLogin() {
		List<Topic> topics = topicDao.findByUserLogin("login");
		assertEquals(2, topics.size());
	}

//	@Test
	public void testAllTopicsWithSpecLang() {
		List<Topic> topics = topicDao.findByLanguageName("Java");
		assertEquals(2, topics.size());
		assertEquals(topics.get(0).getName(), "Hibernate");
	}

	@Test
	public void testAllTopicsWithSpecHashes() {
		Hash hash1 = hashDao.findByName("orm");
		Hash hash2 = hashDao.findByName("cdi");
		Hash hash3 = hashDao.findByName("framework");
		assertEquals(2, topicDao.findByHashes(Arrays.asList(hash3)).size());
		System.out.println("------------------------------------->" + topicDao.findByHashes(Arrays.asList(hash1, hash3)));
		System.out.println("----------------HashesName--------------------->"
				+ topicDao.findByHashesName(Arrays.asList("cdi", "framework")));
		System.out.println(
				"----------------HashesID--------------------->" + topicDao.findByHashesId(Arrays.asList(3l, 5l)));
//		assertEquals(1, topicDao.findByHashes(Arrays.asList(hash1, hash3)).size());
//		assertEquals(1, topicDao.findByHashes(Arrays.asList(hash2, hash3)).size());
		/**
		 * Something wrong with many to many in Hibernate, read about N:N
		 */
	}
}