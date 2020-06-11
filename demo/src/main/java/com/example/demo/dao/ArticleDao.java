package com.example.demo.dao;

/**
 * @author LiZhaoZhuo
 * */

public interface ArticleDao {
	//添加推送
	public boolean addArticle(String articleName, int articleWriter, String articleTpye, String articleAddress);
	
	//修改推送信息
	public boolean changeArticleName(int articleID, String articleName);
	public boolean changeArticleWriter(int articleID, int articleWriter);
	public boolean changeArticleTpye(int articleID, String articleType);
	public boolean changeArticleAddress(int articleID, String articleAddress);
	
	//获取推送信息
	public int getArticleID(String articleName);
	public String getArticleName(int articleID);
	public int getArticleWriterID(int articleID);
	public String getArticleTpye(int articleID);
	public String getArticleAddress(int articleID);
		
	//删除推送
	public boolean deleteArticle(int articleID);		
}
