package com.example.demo.service.impl;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.dao.*;
import com.example.demo.service.*;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private OrderDao order;
	@Autowired
	private OwnerDao owner;
	@Autowired
	private ProductDao product;
	@Autowired
	private ShopDao shop;
	@Autowired
	private TrolleyDao trolley;
	@Autowired
	private UserDao user;
	
	@Override
	public int getuserID(String userName , String userPW) {
		return user.getUserID(userName, userPW);
	}
  
	@Override
	public boolean userRegister(String userName, String userPW) {
		// TODO Auto-generated method stub
		if(user.addUser(userName, userPW)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addDetialInformation(int userID,String userSex, String userPhone, String userBirthday, String userWechat) {
		// TODO Auto-generated method stub

		if(user.changeUserSex(userID, userSex)&&user.changeUserPhone(userID, userPhone)&&user.changeUserBirthday(userID, userBirthday)&&user.changeUserWechat(userID, userWechat)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean userLand(String userName, String userPW) {
		// TODO Auto-generated method stub
		if(user.getUserID(userName, userPW) > 0) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeUserName(int userID,String newUserName) {
		// TODO Auto-generated method stub
		if(user.changeUserName(userID, newUserName)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeUserPW(int userID,String newPW) {
		// TODO Auto-generated method stub
		if(user.changeUserPassword(userID, newPW)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeUserSex(int userID,String newUserSex) {
		// TODO Auto-generated method stub
		if(newUserSex.equals("male")||newUserSex.equals("female")||newUserSex.equals("secret")) {
			if(user.changeUserSex(userID, newUserSex)) {
				return true;
			}else {
				return false;
			}
		} else {
			System.out.println("WRONG SEX TYPE");
			return false;
		}		
	}

	@Override
	public boolean changeUserPhone(int userID,String newUserPhonenumber) {
		// TODO Auto-generated method stub
		if(user.changeUserPhone(userID, newUserPhonenumber)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeUserWechat(int userID,String newUserWechat) {
		// TODO Auto-generated method stub
		if(user.changeUserWechat(userID, newUserWechat)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeUserBirthday(int userID,String newUserBirthday) {
		// TODO Auto-generated method stub
		if(user.changeUserBirthday(userID, newUserBirthday)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public int queryIntegral(int userID) {
		// TODO Auto-generated method stub
		return user.getUserPoint(userID);
	}

	@Override
	public List queryProductWucan() {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		for(int i = 0 ; i < product.getAllProduct().size();i++) {
			int pID = product.getAllProduct().get(i);
			String pr = product.getProductName(pID)+" "+ product.getProductPrice(pID)+" "+product.getProductNumber(pID)+" "+product.getProductInformation(pID);
		    l.add(pr);
		}
		return l;
	}

	@Override
	public List queryProductPN(String productName) {
		List l = new ArrayList();
		for(int i = 0 ; i < product.SearchProduct(productName).size();i++) {
			int pID = product.SearchProduct(productName).get(i);
			String pr = product.getProductName(pID)+" "+ product.getProductPrice(pID)+" "+product.getProductNumber(pID)+" "+product.getProductInformation(pID);
		    l.add(pr);
		}
		return l;
	}

	@Override
	public List queryProductSN(String shopName) {
		List l = new ArrayList();
		int shopId = shop.getShopID(shopName);
		for(int i = 0 ; i < product.getProductFromShop(shopId).size();i++) {
			int pID = product.getProductFromShop(shopId).get(i);
			String pr = product.getProductName(pID)+" "+ product.getProductPrice(pID)+" "+product.getProductNumber(pID)+" "+product.getProductInformation(pID);
		    l.add(pr);
		}
		return l;
	}

	@Override
	public List querytrolleyProduct(int userID,String userName) {
		List l = new ArrayList();
		for(int i = 0 ; i < trolley.getTrolleyProductList(userID).size();i++) {
			int pID = trolley.getTrolleyProductList(userID).get(i);
			String pr = product.getProductName(pID)+" "+ product.getProductPrice(pID)+" "+product.getProductNumber(pID)+" "+product.getProductInformation(pID);
		    l.add(pr);
		}
		return l;
	}

	@Override
	public int querytrolleyProductNumber(int userID,String userName) {
		// TODO Auto-generated method stub
		return trolley.getTrolleyProductList(userID).size();
	}

	@Override
	public boolean addtrolleyProduct(int userID, String productName) {
		int pID =product.getProductID(productName);
		if(trolley.addProductToTrolley(userID, pID, 1)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean deletetrollryProduct(int userID,String productName) {
		int pID =product.getProductID(productName);
		if(trolley.deleteProductInTrolley(userID, pID)) {
			return true;
		}else {
		return false;}
	}

	@Override
	//结算
	public boolean settlementtrolleyProduct(int userID,String productName,int productNumber) {
		int pID =product.getProductID(productName);
		if(order.addOrder(userID, pID, productNumber) && trolley.deleteProductInTrolley(userID, pID)) {
			return true;
		}else {
		return false;}
	}

	@Override
	//查询订单
	public List queryOrder(int userID,String userName) {
		List l = new ArrayList();
		for(int i = 0 ; i < order.getOrderIDByUser(userID).size();i++) {
			int orderid = order.getOrderIDByUser(userID).get(i);
			int pID = order.getOrderProduct(orderid);
			String pr = product.getProductName(pID)+" "+ product.getProductPrice(pID);
		    l.add(pr);
		}
		return l;
	}

	@Override
	//获取商家微信号
	public String queryWeChat(String shopName) {
		// TODO Auto-generated method stub
		int shopId = shop.getShopID(shopName);
        int shopOwnerID = shop.getShopOwner(shopId);
		return owner.getOwnerWechat(shopOwnerID);
	}

	@Override
	//评论（在1.0版本未实现，预计在2.0版本实现）
	public boolean comment(int userID,String productName, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	//推送功能（在1.0版本未实现，预计在2.0版本实现）
	public List queryArticle() {
		// TODO Auto-generated method stub
		return null;
	}

}
