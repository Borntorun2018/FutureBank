package com.eBusiness.security;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OPUS_STAFF_ROLE_LINK")
public class UserRoleLink implements Serializable
{
  private static final long serialVersionUID = -3712318177798333312L;

@Id
@SequenceGenerator(sequenceName = "OSRL_SEQ", allocationSize = 1, name = "OSRL_SEQ")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OSRL_SEQ")
@Column(name = "OSRL_ID", updatable = true, nullable = false)
Long id;
  
  @Column(name = "OSRL_OROL_ID")
  private Long rolId;
    
  @Column(name = "OSRL_USER_ID")
  private Long userId;
  
  public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

@Column(name = "OSRL_CREATION_DATE")
  private Date creationDate;
      
  @Column(name = "OSRL_CREATION_USER")
  private String creationUser;
     
  @Column(name = "OSRL_SOURCE_SYSTEM")
  private String sourceSystem;
      
  public Date getCreationDate() {
	return creationDate;
  }

  public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
  }

  public String getCreationUser() {
	return creationUser;
  }

  public void setCreationUser(String creationUser) {
	this.creationUser = creationUser;
  }

  public String getSourceSystem() {
	return sourceSystem;
  }

  public void setSourceSystem(String sourceSystem) {
	this.sourceSystem = sourceSystem;
  }
  
  public Long getId() {
	return id;
  }
	
  public void setId(Long id) {
		this.id = id;
  }
	
	public Long getRolId() {
		return rolId;
	}
	
	public void setRolId(Long rolId) {
		this.rolId = rolId;
	} 
  
  
}