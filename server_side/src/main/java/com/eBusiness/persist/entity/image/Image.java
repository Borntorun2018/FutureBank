package com.eBusiness.persist.entity.image;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eBusiness.persist.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="OPUS_PERSON_IMAGES")
public class Image implements Serializable{
	private static final long serialVersionUID = -9088619177798333712L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="OPERIMG_ID")
    private long id;
	
	@Column(name="OPERIMG_NAME")
	private String name;
	
	@Column(name="OPERIMG_SIZE")
	private int size;
	
	@Column(name="OPERIMG_TYPE")
	private String type;
		
	@Column(name="OPERIMG_OPER_ID", insertable = false, updatable = false)
	private Long userId;

	@Transient
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="OPERIMG_OPER_ID",referencedColumnName="id")
	@JsonIgnore
	private User user;
	 
	  public void doSetUser(User user) {
	    if (this.user != null && !this.user.equals(user)) {
	      this.user.getImages().remove(this);
	    }
	    user.getImages().add(this);
	    this.user = user;
	  }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
