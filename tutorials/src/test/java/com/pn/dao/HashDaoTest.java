package com.pn.dao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pn.model.Hash;
import com.pn.model.Topic;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HashDaoTest {
	@Autowired
	private HashDao hashDao;
	@Autowired
	private TestEntityManager em;

	@Before
	public void setUp() {
		Hash hash = new Hash();
		hash.setName("orm");
		hash.setTopics(Arrays.asList(new Topic("Hibernate"), new Topic("Spring"), new Topic("Jersey")));
		em.persist(hash);
	}

	@Test
	public void testFindByName() {
		Hash hash = hashDao.findByName("orm");
		assertEquals("Hibernate", hash.getTopics().get(0).getName());
	}
}