package com.codenesia.latihanperpustakaan;

import com.google.gson.annotations.SerializedName;

public class UserLogin {

	@SerializedName("employee_id")
	private String employeeId;

	@SerializedName("employee_name")
	private String employeeName;

	@SerializedName("username")
	private String username;


	public String getEmployeeId(){
		return employeeId;
	}

	public String getEmployeeName(){
		return employeeName;
	}

	public String getUsername(){
		return username;
	}
}