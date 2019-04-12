package com.pn.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pn.model.Hash;

@Repository
public interface HashDao extends CrudRepository<Hash, Long> {
	public Hash findByName(String name);
}
