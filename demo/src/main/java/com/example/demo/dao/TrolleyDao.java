package com.example.demo.dao;

import java.util.List;

/**
 * @author LiZhaoZhuo
 * */

public interface TrolleyDao {
	//添加商品到购物车
	public boolean addProductToTrolley(int userID, int productID, int productNumber);
	
	//修改购物车产品信息
	public boolean changeProduct(int userID, int productID, int productNumber);	
	
	//获取购物车信息
	public List<Integer> getTrolleyProductList(int userID);
	public int getTrolleyProductNumber(int userID, int productID);
		
	//删除购物车商品
	public boolean deleteProductInTrolley(int userID, int productID);	
}
