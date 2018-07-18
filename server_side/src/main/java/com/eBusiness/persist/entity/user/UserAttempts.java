package com.eBusiness.persist.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="OPUS_STAFF_ATTEMPTS")
	public class UserAttempts implements Serializable{
		private static final long serialVersionUID = -7888819177798333712L;

		public UserAttempts(){}
		public UserAttempts(String username, int attempts, Date lastModified ){
			this.username = username;
			this.attempts = attempts;
			this.lastModified = lastModified;
		}		
		
		@Id
		@Column(name="OSA_EMAIL")
		private String username;
		
		@Column(name="OSA_ATTEMPTS")
		private int attempts;
		
		@Column(name="OSA_LASTMODIFIED")
		private Date lastModified;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
						
		public int getAttempts() {
			return attempts;
		}

		public void setAttempts(int attempts) {
			this.attempts = attempts;
		}

		public Date getLastModified() {
			return lastModified;
		}

		public void setLastModified(Date lastModified) {
			this.lastModified = lastModified;
		}	
}
