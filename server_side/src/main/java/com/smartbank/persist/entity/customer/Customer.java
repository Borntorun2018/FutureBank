package com.smartbank.persist.entity.customer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id private String username;
	private String surname;
	private String forenames;
	private Date dob;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getForenames() {
		return forenames;
	}
	public void setForenames(String forenames) {
		this.forenames = forenames;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
}
