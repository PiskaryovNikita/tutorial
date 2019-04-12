package com.pn.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min = 4, max = 40, message = "login should be from 4 to 40 symbols") // regex
	private String login;
	@Size(min = 6, max = 50, message = "password should be min. 6 symbols")
	private String password;
	@Size(min = 6, max = 50, message = "email should be min. 6 symbols")
	private String email;
	@Size(min = 2, max = 30, message = "Enter valid First name")
	private String firstName;
	@Size(min = 2, max = 30, message = "Enter valid Last name")
	private String lastName;
	private Date birthday;
	private String role;

	public User() {
	}

	public User(@Size(min = 4, max = 40, message = "login should be from 4 to 40 symbols") String login,
			@Size(min = 6, max = 50, message = "password should be min. 6 symbols") String password,
			@Size(min = 6, max = 50, message = "email should be min. 6 symbols") String email,
			@Size(min = 2, max = 30, message = "Enter valid First name") String firstName,
			@Size(min = 2, max = 30, message = "Enter valid Last name") String lastName, Date birthday, String role) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		User user = (User) obj;
		return (login == user.login || (login != null && login.equals(user.login)))
				&& (password == user.password || (password != null && password.equals(user.password)))
				&& (email == user.email || (email != null && email.equals(user.email)))
				&& (firstName == user.firstName || (firstName != null && firstName.equals(user.firstName)))
				&& (lastName == user.lastName || (lastName != null && lastName.equals(user.lastName)))
				&& (role == user.role || (role != null && role.equals(user.role)))
				&& (birthday == user.birthday || (birthday != null && birthday.equals(user.birthday)));
	}

	@Override
	public String toString() {
		return "{" + id + ":" + login + ", " + password + ", " + email + ", " + firstName + ", " + lastName + ", "
				+ birthday + ", " + role + "(FK)}";
	}
}
