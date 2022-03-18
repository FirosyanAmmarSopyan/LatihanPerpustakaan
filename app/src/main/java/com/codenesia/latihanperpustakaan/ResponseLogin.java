package com.codenesia.latihanperpustakaan;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private UserLogin user;

	@SerializedName("status")
	private String status;





	public String getMessage(){
		return message;
	}

	public UserLogin getUser(){
		return user;
	}

	public String getStatus(){
		return status;
	}
}