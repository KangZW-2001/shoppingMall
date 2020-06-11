package com.example.demo.dao.impl;

import com.example.demo.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author LiZhaoZhuo
 * */

@Repository
public class ShopDaoImpl implements ShopDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addShop(String shopName, int shopOwnerID) {
		String sql = "insert into shop(shopName, shopOwner) values(?,?)";
	    if( this.jdbcTemplate.update(sql, shopName, shopOwnerID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }	
	}

	@Override
	public boolean addProductToShop(int shopID, String productName, double productPrice, int productNumber,
			String productInformation) {
		String sql = "insert into product(shopID, productName, productPrice, productNumber, productInformation) values(?,?,?,?,?)";
	    if( this.jdbcTemplate.update(sql, shopID, productName, productPrice, productNumber, productInformation) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }	
	}

	@Override
	public boolean changeShopName(int shopID, String shopName) {
		String sql = "update shop set shopName = ? where shopID = ?";
	    if( this.jdbcTemplate.update(sql, shopName, shopID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public int getShopID(String shopName) {
		String sql = "select shopID from shop where shopName = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, shopName);
	}

	@Override
	public String getShopName(int shopID) {
		String sql = "select shopName from shop where shopID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, shopID);
	}

	@Override
	public int getShopOwner(int shopID) {
		String sql = "select shopOwner from shop where shopID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, shopID);
	}

	@Override
	public boolean deleteShop(int shopID) {
		String sql="delete from shop where shopID =?";
		if(jdbcTemplate.update(sql, shopID) != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteProductInShop(int shopID, int productID) {
		String sql="delete from product where userID = ? AND productID = ?";
		if(jdbcTemplate.update(sql, shopID, productID) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
