package com.user.userService.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {
	@Id
	private String id;
	private String name;
	private String mail;
	private String about;

	@Transient
	List<Rating> ratingList = new ArrayList<>();
	

	public User() {
		super();
	}

	public User(String id, String name, String mail, String about, List<Rating> ratingList) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.about = about;
		this.ratingList = ratingList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mail=" + mail + ", about=" + about + ", ratingList="
				+ ratingList + "]";
	}

}
