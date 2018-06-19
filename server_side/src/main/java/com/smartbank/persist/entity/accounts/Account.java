package com.smartbank.persist.entity.accounts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.smartbank.persist.entity.customer.Customer;



@Entity
public class Account {

	@Id private Long id;
	private String type;
	@OneToOne private Customer owner;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Customer getOwner() {
		return owner;
	}
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	
}
