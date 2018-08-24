package com.example.rest.websevices.restfullwebservice.User;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	private Integer userId;

	@Size(min = 3, message = "Name should have three char")
	private String name;

	@Past
	private Date dob;

	protected User() {

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public User(Integer userId, String name, Date dob) {

		this.userId = userId;
		this.name = name;
		this.dob = dob;
	}

}
