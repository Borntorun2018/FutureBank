package com.eBusiness.model;
import java.io.Serializable;
import java.util.Set;

import com.eBusiness.persist.entity.user.User;
import com.eBusiness.security.Role;

public class UserRoleRequestWrapper implements Serializable{
	
	private static final long serialVersionUID = -4788719177798333712L;
	private User user;
  	private Set<Role> roles;
    
 	
    public User getUser() {
    	
  		return user;
  	}
  	public void setUser(User user) {
  		this.user = user;
  	}

  	public Role getRole() {
  		
  		if (!roles.isEmpty()){
  			return roles.iterator().next();
  		}else{
  		    return null; 	
  		}
  	}
  	public Set<Role> getRoles() {
  		return roles;
  	}
  	public void setRoles(Set<Role> roles) {
  		this.roles = roles;
  	}
}
