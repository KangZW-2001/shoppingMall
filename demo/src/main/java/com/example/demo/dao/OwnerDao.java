package com.example.demo.dao;

/**
 * @author LiZhaoZhuo
 * */

public interface OwnerDao {
	//添加卖家
	public boolean addOwner(String ownerName, String ownerPassword, String ownerIDcard, String ownerPhone, String ownerWechat);
	
	//修改卖家信息
	public boolean changeOwnerName(int ownerID, String ownerName);
	public boolean changeOwnerPassword(int userID, String ownerPassword);
	public boolean changeOwnerIDcard(int userID, String ownerIDcard);
	public boolean changeOwnerPhone(int userID, String ownerPhone);
	public boolean changeOwnerWechat(int userID, String ownerWechat);

	//获取卖家信息
	public int getOwnerID(String ownerName);
	public String getOwnerName(int ownerID);
	public String getOwnerPassword(int ownerID);
	public int getOwnerPower(int ownerID);
	public String getOwnerIDcard(int ownerID);
	public String getOwnerPhone(int ownerID);
	public String getOwnerWechat(int ownerID);
	
	//删除卖家
	public boolean deleteOwner(int ownerID);
}
