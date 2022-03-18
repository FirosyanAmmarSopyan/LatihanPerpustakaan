package com.codenesia.latihanperpustakaan;

import com.google.gson.annotations.SerializedName;

public class BookItem{

	@SerializedName("year")
	private int year;

	@SerializedName("author")
	private String author;

	@SerializedName("publisher")
	private String publisher;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("stock")
	private int stock;

	public int getYear(){
		return year;
	}

	public String getAuthor(){
		return author;
	}

	public String getPublisher(){
		return publisher;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public int getStock(){
		return stock;
	}
}