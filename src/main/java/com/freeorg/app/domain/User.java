package com.freeorg.app.domain;

public class User {
	private String id;
	private String mobileNumber;
	
	public User(String id, String mobileNumber) {
		this.id = id;
		this.mobileNumber = mobileNumber;
	}

	public String getId() {
		return id;
	}
}
