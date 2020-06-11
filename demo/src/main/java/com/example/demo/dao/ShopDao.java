package com.example.demo.dao;

/**
 * @author LiZhaoZhuo
 * */

public interface ShopDao {
	//添加店铺
	public boolean addShop(String shopName, int shopOwnerID);
	//添加商品到店铺
	public boolean addProductToShop(int shopID, String productName, double productPrice, int productNumber, String productInformation);	
	//修改店铺信息
	public boolean changeShopName(int shopID, String shopName);
	//获取店铺信息
	public int getShopID(String shopName);
	public String getShopName(int shopID);
	public int getShopOwner(int shopID);	
	//删除店铺
	public boolean deleteShop(int shopID);
	//删除店铺内商品
	public boolean deleteProductInShop(int shopID, int productID);
}
