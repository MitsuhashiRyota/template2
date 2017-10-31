package com.internousdev.komozon.dto;

public class LoginDTO {

	private String userId;

	private String password;

	private String userName;

	private int logineds = 0;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLogineds() {
		return logineds;
	}

	public void setLogineds(int logineds) {
		this.logineds = logineds;
	}

}
