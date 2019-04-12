package com.pn.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Hash {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Topic> topics;

	public Hash() {
	}

	public Hash(String name) {
		this.name = name;
	}

	public Hash(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Hash(long id, String name, List<Topic> topics) {
		this.id = id;
		this.name = name;
		this.topics = topics;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return id + ", " + name;
	}
}
