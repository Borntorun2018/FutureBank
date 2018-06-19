package com.smartbank.model;

import java.util.List;
import com.smartbank.security.SecurityUser;

public class SecurityUserResponse extends Response {
	
	private List<SecurityUser> users;

	public List<SecurityUser> getUsers() {
		return users;
	}

	public void setUsers(List<SecurityUser> users) {
		this.users = users;
	}
}
