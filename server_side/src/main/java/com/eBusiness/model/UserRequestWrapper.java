package com.eBusiness.model;
import java.io.Serializable;

import com.eBusiness.pagination.Pagination;
import com.eBusiness.persist.entity.user.User;


public class UserRequestWrapper implements Serializable{
	private static final long serialVersionUID = -6788719177798333712L;
	private User user;
    private Pagination pagination;
    
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
