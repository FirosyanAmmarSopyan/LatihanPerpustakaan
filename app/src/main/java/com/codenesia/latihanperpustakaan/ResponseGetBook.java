package com.codenesia.latihanperpustakaan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseGetBook{

	@SerializedName("book")
	private List<BookItem> book;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public List<BookItem> getBook(){
		return book;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}