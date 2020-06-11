package com.example.demo.entity;

public class Article {
	private int articleID;
	private String articleName;
	private int articleWriterID;
	private String articleType;
	private String articleAddress;
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public int getArticleWriterID() {
		return articleWriterID;
	}
	public void setArticleWriterID(int articleWriterID) {
		this.articleWriterID = articleWriterID;
	}
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public String getArticleAddress() {
		return articleAddress;
	}
	public void setArticleAddress(String articleAddress) {
		this.articleAddress = articleAddress;
	}
	
}
