package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author LiZhaoZhuo
 * */

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean addUser(String userName, String userPassword) {
		System.out.println("userName = " + userName);
		System.out.println("userPassword = " + userPassword);
		
		String sql = "insert into user(userName, userPassword) values(?,?)";
	    if( this.jdbcTemplate.update(sql, userName, userPassword) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }	      
	}

	@Override
	public boolean addUser(String userName, String userPW, String userSex, String userPhone, String userBirthday,
			String userWechat) {
		String sql = "insert into user(userName, userPassword, userSex, userPhone, userBirthday) values(?,?,?,?,?)";
	    if( this.jdbcTemplate.update(sql, userName, userPW, userSex, userPhone, userBirthday) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeUserName(int userID, String userName) {
		String sql = "update user set userName = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, userName, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeUserPassword(int userID, String userPassword) {
		String sql = "update user set userPassword = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, userPassword, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeUserSex(int userID, String userSex) {
		String sql = "update user set userSex = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, userSex, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeUserPoint(int userID, int Point) {
		String sql = "update user set userPoint = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, Point, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeUserPhone(int userID, String userPhone) {
		String sql = "update user set userPhone = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, userPhone, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
	public boolean changeUserBirthday(int userID, String userBirthday) {
		String sql = "update user set userBirthday = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, userBirthday, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeUserWechat(int userID, String userWechat) {
		String sql = "update user set userWechat = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, userWechat, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	@Override
	public int getUserID(String userName, String userPassword) {
		String sql = "select userID from user where userName = ? AND userPassword = ?";
		if (this.jdbcTemplate.queryForObject(sql, Integer.class, userName, userPassword) == null) {
			return 0;
		} else {
		return this.jdbcTemplate.queryForObject(sql, Integer.class, userName, userPassword);
		}
	}

	@Override
	public String getUserName(int userID) {
		String sql = "select userName from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, userID);
	}

	@Override
	public String getUserPassword(int userID) {
		String sql = "select userPassword from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, userID);
	}

	@Override
	public int getUserPower(int userID) {
		String sql = "select userPower from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, userID);
	
	}

	@Override
	public String getUserSex(int userID) {
		String sql = "select userSex from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, userID);
	
	}

	@Override
	public int getUserPoint(int userID) {
		String sql = "select userPoint from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, userID);
	
	}

	@Override
	public String getUserPhone(int userID) {
		String sql = "select userPhone from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, userID);
	
	}

	@Override
	public String getUserBirthday(int userID) {
		String sql = "select userBirthday from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, userID);
	
	}

	@Override
	public String getUserWechat(int userID) {
		String sql = "select userWechat from user where userID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, userID);
	}

	@Override
	public boolean deleteUser(int userID) {
		String sql="delete from user where userID=?";
		if(jdbcTemplate.update(sql, userID) != 0) {
			return true;
		} else {
			return false;
		}
	}

	
}
