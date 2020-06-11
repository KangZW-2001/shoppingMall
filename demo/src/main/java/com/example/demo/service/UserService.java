package com.example.demo.service;

import java.util.List;

public interface UserService {
	//用户功能
	//获取用户ID
	public int getuserID(String userName , String userPW);
	//用户注册
	public boolean userRegister(String userName , String userPW);
	//用户添加详细信息
	public boolean addDetialInformation(int userID,String userSex, String userPhone, String userBirthday, String userWechat);
	//用户登陆
	public boolean userLand(String userName,String userPW);
	//更改名字
	public boolean changeUserName(int userID,String newUserName);
	//更改密码
	public boolean changeUserPW(int userID,String newPW);
	//更改性别
	public boolean changeUserSex(int userID,String newUserSex);
	//更改电话号码
	public boolean changeUserPhone(int userID,String newUserPhonenumber);
	//更改微信号
	public boolean changeUserWechat(int userID,String newUserWechat);
	//更改生日
	public boolean changeUserBirthday(int userID,String newUserBirthday);
	//用户查询积分
	public int queryIntegral(int userID);
	//查商品，无参
	public List queryProductWucan();
	//查商品，根据商品名
	public List queryProductPN(String productName);
	//查商品，根据商店名
	public List queryProductSN(String shopName);
	
	//查看购物车中的商品
	public List querytrolleyProduct(int userID,String userName);
	//查看购物车中的商品数量
	public int querytrolleyProductNumber(int userID,String userName);
	//添加商品进购物车
	public boolean addtrolleyProduct(int userID,String productName);
	//删除购物车中的商品
	public boolean deletetrollryProduct(int userID,String productName);
	//结算购物车中的商品
	public boolean settlementtrolleyProduct(int userID,String productName,int productNumber);
	//查询所有的订单
	public List queryOrder(int userID,String userName);
	//根据商店的名字获取商家的微信号
	public String queryWeChat(String shopName);
	//用户发布评论
	public boolean comment(int userID,String productName, String comment);
	//用户获取推送
	public List queryArticle();
}
