package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.*;
import com.example.demo.dao.impl.*;
import com.example.demo.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private ArticleDao article;
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
	public int getOwnerID(String ownerName,String ownerPW) {
		return owner.getOwnerID(ownerName);
	}
	
	@Override
	public int getshopID(String shopName) {
		return shop.getShopID(shopName);
	};
	
	@Override
	public boolean ownerRegister(String ownerName, String ownerPW, String ownerIDcard, String ownerPhone, String ownerWechat) {
		// TODO Auto-generated method stub
		if(owner.addOwner(ownerName, ownerPW, ownerIDcard,ownerPhone,ownerWechat)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean ownerLand(String ownerName, String ownerPW) {
		// TODO Auto-generated method stub
		if(owner.getOwnerID(ownerName) > 0) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeOwnerName(int ownerID,String newOwnerName) {
		// TODO Auto-generated method stub
		if(owner.changeOwnerName(ownerID, newOwnerName)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeOwnerPW(int ownerID,String ownerPW) {
		// TODO Auto-generated method stub
		if(owner.changeOwnerPassword(ownerID, ownerPW)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeOwnerPhone(int ownerID,String newOwnerPhonenumber) {
		// TODO Auto-generated method stub
		if(owner.changeOwnerPhone(ownerID, newOwnerPhonenumber)) {
			return true;
		}else {
		return false;}
	}

	@Override
	public boolean changeOwnerWechat(int ownerID,String newOwnerWechat) {
		// TODO Auto-generated method stub
		if(owner.changeOwnerWechat(ownerID, newOwnerWechat)) {
			return true;
		}else {
		return false;}
	}
	
	@Override
	public boolean registerShop(String shopName, int shopOwner) {
		if(shop.addShop(shopName, shopOwner)) {
		return true;
	}else {
	return false;}
    }
	
	@Override
	public boolean changeShopName(int shopID, String newShopName) {
		if(shop.changeShopName(shopID,newShopName)) {
			return true;
		}else {
		return false;}
	}
	
	@Override
	public boolean deleteShop(int shopID) {
	if(shop.deleteShop(shopID)) {
		return true;
	}else {
	return false;}
    }

	@Override
	//上架商品
	public boolean putOnproduct(int shopID, String productName, double productPrice){
		if(shop.addProductToShop(shopID, productName, productPrice, 100, "hao dong xi")) {
			return true;
		}else {
		return false;}
	}
	
	//下架商品
	public boolean deleteProduct(int shopID,String productName) {
		if(shop.deleteProductInShop(shopID, product.getProductID(productName))) {
			return true;
		}else {
			return false;
		}
	}

	//更改商品价格
	public boolean changeProductPrice(int shopID,String productName, double newproductPrice) {
		if(product.changeProductPrice(shopID,product.getProductID(productName),newproductPrice)) {
			return true;
		}else {
			return false;
		}
	}
	//更改商品名字
	public boolean changeProductName(int shopID,String productName, String newproductName) {
		if(product.changeProductName(shopID,product.getProductID(productName), newproductName)) {
			return true;
		}else {
			return false;
		}
	}
	//更改商品描述
	public boolean changeProductInformation(int shopID,String productName, String newproductInformation) {
		if(product.changeProductInformation(shopID,product.getProductID(productName), newproductInformation)) {
			return true;
		}else {
			return false;
		}
}
	
	//更改商品库存
	public boolean changeProductStock(int shopID, String productName, int stock) {
		if(product.changeProductNumber(shopID,product.getProductID(productName),stock)){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addProductInformation(int shopID, String productName, String productInformation) {
		if(product.changeProductInformation(shopID,product.getProductID(productName), product.getProductInformation(product.getProductID(productName)) + productInformation)) {
			return true;
		}else {
			return false;
		}
	}
}
