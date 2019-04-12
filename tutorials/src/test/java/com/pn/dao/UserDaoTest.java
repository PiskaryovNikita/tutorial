package com.pn.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pn.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoTest {
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private UserDao userDao;
	
	@Before
	public void init() {
		User user = new User();
		user.setLogin("SuYunLiang");
		user.setEmail("lsxx@12cc.jj");
		user.setFirstName("Suyun");
		user.setLastName("Liang");
		user.setPassword("qwerty");
		user.setRole("Admin");
		entityManager.persist(user);
	}

	@Test
	public void testFindByLogin() {
		User user = userDao.findByLogin("SuYunLiang");
		assertEquals("SuYunLiang", user.getLogin());
	}

	@Test
	public void testFindByEmail() {
		User user = userDao.findByEmail("lsxx@12cc.jj");
		assertEquals("lsxx@12cc.jj", user.getEmail());
	}
}