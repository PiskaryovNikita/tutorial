package com.pn.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@Lob
	@Column(length = 100000)
	private byte[] data;
	@ManyToOne
	private Language language;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;
	@ManyToMany
	private List<Hash> hashes;

	public Topic() {
	}
	
	public Topic(String name) {
		this.name = name;
	}

	public Topic(String name, Language language, User user, List<Hash> hashes) {
		super();
		this.name = name;
		this.language = language;
		this.user = user;
		this.hashes = hashes;
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Hash> getHashes() {
		return hashes;
	}

	public void setHashes(List<Hash> hashes) {
		this.hashes = hashes;
	}
	
	@Override
	public String toString() {
		return "{" + id + ", " + name + ", " + language + ", " + hashes + ", " + user + "}";
	}
}
