package com.example.rest.websevices.restfullwebservice.User;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="All info about User")
public class User {

	private Integer userId;

	@Size(min = 3, message = "Name should have atleast three char")
	@ApiModelProperty (notes = "Name should have atleast three char")
	private String name;

	@Past
	@ApiModelProperty (notes = "DOB should be in past")
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
