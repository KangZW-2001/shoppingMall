package com.example.demo.dao.impl;

import com.example.demo.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LiZhaoZhuo
 * */
@Repository
public class OrderDaoImpl implements OrderDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addOrder(int userID, int productID, int productNumber) {
		String sql = "insert into orders(userID, productID, productNumber) values("+ userID + "," + productID + "," + productNumber +")";
	    if( this.jdbcTemplate.update(sql) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
	public int getOrderID(int userID, int productID) {
		String sql = "select orderID from orders where userID = ? and productID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class,userID, productID);
	}
	
	@Override
	public List<Integer> getOrderIDByUser(int userID) {
		String sql = "select orderID from orders where userID = " + userID;
		List<Integer> data = jdbcTemplate.query(sql, new RowMapper<Integer>(){
		    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	return rs.getInt(1);
		    }

		});
		return data;
	}

	@Override
	public int getOrderUser(int OrderID) {
		String sql = "select orderUser from orders where OrderID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, OrderID);
	}

	@Override
	public int getOrderProduct(int OrderID) {
		String sql = "select productID from orders where OrderID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, OrderID);
	
	}

	@Override
	public int getOrderProductNumber(int userID, int OrderID, int productID) {
		String sql = "select orderProductNumber from orders where userID = ? and OrderID = ? and productID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, userID, OrderID, productID);
	}

	@Override
	public String getOrderDate(int orderID) {
		String sql = "select orderDate from orders where orderID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, orderID);
	}
}
