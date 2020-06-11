package com.example.demo.dao;

import java.util.List;

/**
 * @author LiZhaoZhuo
 * */

public interface OrderDao {
	public boolean addOrder(int userID, int productID, int productNumber);
	//获取订单信息
	public int getOrderID(int userID, int productID);
	public List<Integer> getOrderIDByUser(int userID);
	public int getOrderUser(int OrderID);
	public int getOrderProduct(int OrderID);
	public int getOrderProductNumber(int userID, int OrderID, int productID);
	public String getOrderDate(int orderID);
}
