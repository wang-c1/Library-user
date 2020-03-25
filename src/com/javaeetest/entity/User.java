package com.javaeetest.entity;

public class User {

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userNickName;
	private String userSex;
	private String userPhone;
	private String userRemark;

	public User() {
		
	}

	public User(String userName, String userPassword,String userEmail, String userNickName, String userSex,
			String userPhone, String userRemark) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userNickName = userNickName;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userRemark = userRemark;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}



}
