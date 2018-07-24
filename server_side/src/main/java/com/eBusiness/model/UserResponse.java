package com.eBusiness.model;

import org.springframework.data.domain.Page;

import com.eBusiness.persist.entity.user.User;

public class UserResponse extends Response {
	
	private Page<User> users;

	public Page<User> getUsers() {
		return users;
	}

	public void setUsers(Page<User> users) {
		this.users = users;
	}
}
