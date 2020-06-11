package com.example.demo.dao.impl;

import com.example.demo.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiZhaoZhuo
 * */

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean changeProductName(int shopID, int productID, String productName) {
		String sql = "update product set productName = ? where shopID = ? and productID = ?";
	    if( this.jdbcTemplate.update(sql, productName, shopID, productID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeProductPrice(int shopID, int productID, double productPrice) {
		String sql = "update product set productPrice = ? where shopID = ? and productID = ?";
	    if( this.jdbcTemplate.update(sql, productPrice, shopID, productID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeProductInformation(int shopID, int productID, String productInformation) {
		String sql = "update product set productInformation = ? where shopID = ? and productID = ?";
	    if( this.jdbcTemplate.update(sql, productInformation, shopID, productID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeProductNumber(int shopID, int productID, int productNumber) {
		String sql = "update product set productNumber = ? where shopID = ? and productID = ?";
	    if( this.jdbcTemplate.update(sql, productNumber, shopID, productID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public int getProductID(String productName) {
		String sql = "select productID from product where productName = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, productName);
	}
	
	@Override
	public int getProductShop(int productID) {
		String sql = "select shopID from product where productID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, productID);
	}
	
	@Override
	public String getProductName(int productID) {
		String sql = "select productName from product where productID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, productID);
	}

	@Override
	public int getProductPrice(int productID) {
		String sql = "select productPrice from product where productID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, productID);
	}

	@Override
	public int getProductNumber(int productID) {
		String sql = "select productNumber from product where productID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, productID);
	}

	@Override
	public String getProductInformation(int productID) {
		String sql = "select productInformation from product where productID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, productID);
	}

	@Override
	public List<Integer> getProductFromShop(int shopID) {
		String sql = "select productID from product where shopID = " + shopID;
		List<Integer> data = jdbcTemplate.query(sql, new RowMapper<Integer>(){
		    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return rs.getInt(1);
		    }

		});
		return data;
	}

	@Override
	public List<Integer> getAllProduct() {
		String sql = "select productID from product";
		List<Integer> data = jdbcTemplate.query(sql, new RowMapper<Integer>(){
		    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return rs.getInt(1);
		    }

		});
		return data;
	}

	@Override
	public List<Integer> SearchProduct(String keyWord) {
		String sql = "select productID from product where productName like '%" + keyWord + "%'";
		List<Integer> data = jdbcTemplate.query(sql, new RowMapper<Integer>(){
		    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return rs.getInt(1);
		    }
		});
		System.out.println("data = " + data.toString());
		return data;
	}	
}
