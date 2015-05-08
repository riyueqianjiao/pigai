package com.pigai.vo;

public class User {
	
	private Integer userId;
	private String userNo;
	private String userName;

	public User() {

	}
	public User(Integer userId, String userNo, String userName) {
		super();
		this.userId = userId;
		this.userNo = userNo;
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	


}
