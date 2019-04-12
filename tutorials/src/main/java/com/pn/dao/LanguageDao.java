package com.pn.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pn.model.Language;

@Repository
public interface LanguageDao extends CrudRepository<Language, Long> {
	public Language findByName(String name);
}
