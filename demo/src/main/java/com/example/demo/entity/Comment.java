package com.example.demo.entity;

public class Comment {
	private int userID;
	private int productID;
	private String commentType;
	private String commentDate;
	private String commentContent;
	
	public int getUserID() {
		return userID;
	}
	public int getProductID() {
		return productID;
	}
	public String getCommentType() {
		return commentType;
	}
	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
