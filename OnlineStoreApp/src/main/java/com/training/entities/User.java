package com.training.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author User1
 *
 */
@Entity
public class User {

	@Id
	private Long userId;
	private String username;
	private String userEmail;
	private String userPhone;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
