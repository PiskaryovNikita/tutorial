package com.pn.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pn.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	public User findByLogin(String login);
	public User findByEmail(String email);
}
