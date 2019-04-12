package com.pn.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pn.model.Hash;
import com.pn.model.Topic;

@Repository
public interface TopicDao extends CrudRepository<Topic, Long> {
	public Topic findByName(String name);
	public List<Topic> findByLanguageName(String name);
	public List<Topic> findByUserLogin(String login);
	public List<Topic> findByHashes(List<Hash> hashes);
	//По одному хешу - без проблем, два - нет
	public List<Topic> findByHashesName(List<String> hashesNames);
	public List<Topic> findByHashesId(List<Long> hashesIds);
}
