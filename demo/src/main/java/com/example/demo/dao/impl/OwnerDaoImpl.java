package com.example.demo.dao.impl;

import com.example.demo.dao.OwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author LiZhaoZhuo
 * */

@Repository
public class OwnerDaoImpl implements OwnerDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addOwner(String ownerName, String ownerPassword, String ownerIDcard, String ownerPhone, String ownerWechat) {
		String sql = "insert into owner(ownerName, ownerPassword, ownerIDcard, ownerPhone, ownerWechat ) values(?,?,?,?,?)";
    	if( this.jdbcTemplate.update(sql, ownerName, ownerPassword, ownerIDcard, ownerPhone, ownerWechat) != 0) {
    		return true;
    	} else {
    		return false;
    	}
	}

	@Override
	public boolean changeOwnerName(int ownerID, String ownerName) {
		String sql = "update owner set ownerName = ? where ownerID = ?";
	    if( this.jdbcTemplate.update(sql, ownerName, ownerID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeOwnerPassword(int ownerID, String ownerPassword) {
		String sql = "update owner set ownerPassword = ? where ownerID = ?";
	    if( this.jdbcTemplate.update(sql, ownerPassword, ownerID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeOwnerIDcard(int ownerID, String ownerIDcard) {
		String sql = "update owner set ownerIDcard = ? where ownerID = ?";
	    if( this.jdbcTemplate.update(sql, ownerIDcard, ownerID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeOwnerPhone(int ownerID, String ownerPhone) {
		String sql = "update owner set ownerPhone = ? where ownerID = ?";
	    if( this.jdbcTemplate.update(sql, ownerPhone, ownerID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeOwnerWechat(int userID, String ownerWechat) {
		String sql = "update owner set ownerWechat = ? where userID = ?";
	    if( this.jdbcTemplate.update(sql, ownerWechat, userID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public int getOwnerID(String ownerName) {
		String sql = "select ownerID from owner where ownerName = ?";
		if (this.jdbcTemplate.queryForObject(sql, Integer.class, ownerName) == null) {
			return 0;
		} else {
		return this.jdbcTemplate.queryForObject(sql, Integer.class, ownerName);
		}
	}

	@Override
	public String getOwnerName(int ownerID) {
		String sql = "select ownerName from owner where ownerID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, ownerID);
	}

	@Override
	public String getOwnerPassword(int ownerID) {
		String sql = "select ownerPassword from owner where ownerID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, ownerID);
	}

	@Override
	public int getOwnerPower(int ownerID) {
		String sql = "select ownerPower from owner where ownerID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, ownerID);
	}

	@Override
	public String getOwnerIDcard(int ownerID) {
		String sql = "select ownerIDcard from owner where ownerID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, ownerID);
	}

	@Override
	public String getOwnerPhone(int ownerID) {
		String sql = "select ownerPhone from owner where ownerID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, ownerID);
	}

	@Override
	public String getOwnerWechat(int ownerID) {
		String sql = "select ownerWechat from owner where ownerID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, ownerID);
	}

	@Override
	public boolean deleteOwner(int ownerID) {
		String sql="delete from owner where ownerID=?";
		if(jdbcTemplate.update(sql, ownerID) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
