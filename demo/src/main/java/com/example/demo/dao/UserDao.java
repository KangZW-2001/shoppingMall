package com.example.demo.dao;

/**
 * @author LiZhaoZhuo
 * */

public interface UserDao {
	//添加用户（简单）
	public boolean addUser(String userName, String userPW);
	//添加用户（完整）
	public boolean addUser(String userName, String userPW, String userSex, String userPhone, String userBirthday, String userWechat);
	
	//修改用户信息
	public boolean changeUserName(int userID, String userName);
	public boolean changeUserPassword(int userID, String userPassword);
	public boolean changeUserSex(int userID, String userSex);
	public boolean changeUserPoint(int userID, int Point);
	public boolean changeUserPhone(int userID, String userPhone);
	public boolean changeUserBirthday(int userID, String userBirthday);
	public boolean changeUserWechat(int userID, String userWechat);
	
	//获取用户信息
	public int getUserID(String userName, String userPassword);
	public String getUserName(int userID);
	public String getUserPassword(int userID);
	public int getUserPower(int userID);
	public String getUserSex(int userID);
	public int getUserPoint(int userID);
	public String getUserPhone(int userID);
	public String getUserBirthday(int userID);
	public String getUserWechat(int userID);
	
	//删除用户
	public boolean deleteUser(int userID);
}
