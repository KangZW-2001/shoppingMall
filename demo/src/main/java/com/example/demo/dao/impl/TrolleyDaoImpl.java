package com.example.demo.dao.impl;

import com.example.demo.dao.TrolleyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author LiZhaoZhuo
 * */

@Repository
public class TrolleyDaoImpl implements TrolleyDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addProductToTrolley(int userID, int productID, int productNumber) {
		String sql = "insert into trolley(userID, productID, productNumber) values(?,?,?)";
	    if( this.jdbcTemplate.update(sql, userID, productID, productNumber) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }	
	}

	@Override
	public boolean changeProduct(int userID, int productID, int productNumber) {
		String sql = "update trolley set productID = ? and productNumber = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, productID, productNumber, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public List<Integer> getTrolleyProductList(int userID) {
		String sql = "select productID from trolley where userID = ?";
		return this.jdbcTemplate.queryForList(sql, Integer.class, userID);
	}

	@Override
	public int getTrolleyProductNumber(int userID, int productID) {
		String sql = "select productNumber from trolley where userID = ? and productID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, userID, productID);
	}

	@Override
	public boolean deleteProductInTrolley(int userID, int productID) {
		String sql="delete from trolley where userID = ? and productID = ?";
		if(jdbcTemplate.update(sql, userID, productID) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
