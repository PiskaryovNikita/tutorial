package com.pn.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pn.model.Language;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LanguageDaoTest {
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private LanguageDao languageDao;

	@Test
	public void testFindByName() {
		Language language = new Language();
		language.setName("Java");
		entityManager.persist(language);

		Language lang = languageDao.findByName("Java");
		assertEquals("Java", lang.getName());
	}
}