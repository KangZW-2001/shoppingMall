package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Product;
/**
 * @author LiZhaoZhuo
 * */
public interface ProductDao {
	//修改商品信息
	public boolean changeProductName(int shopID, int productID, String productName);
	public boolean changeProductPrice(int shopID, int productID, double productPrice);
	public boolean changeProductInformation(int shopID, int productID, String productInformation);
	public boolean changeProductNumber(int shopID, int productID, int prodouctNumber);
	
	//获取商品信息
	public int getProductID(String productName);
	public int getProductShop(int productID);
	public String getProductName(int productID);
	public int getProductPrice(int productID);
	public int getProductNumber(int productID);
	public String getProductInformation(int productID);		
	
	public List<Integer> getProductFromShop(int shopID);
	public List<Integer> getAllProduct();
	public List<Integer> SearchProduct(String keyWord);
}
