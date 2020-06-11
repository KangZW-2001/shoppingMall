package com.example.demo.dao.impl;

import com.example.demo.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author LiZhaoZhuo
 * */

@Repository
public class ArticleDaoImpl implements ArticleDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addArticle(String articleName, int articleWriter, String articleTpye, String articleAddress) {
		String sql = "insert into Article(articleName, articleWriter, articleTpye, articleAddress) values(?,?,?,?)";
	    if( this.jdbcTemplate.update(sql, articleName, articleWriter, articleTpye, articleAddress) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeArticleName(int articleID, String articleName) {
		String sql = "update article set articleName = ? where articleID = ?";
	    if( this.jdbcTemplate.update(sql, articleName, articleID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeArticleWriter(int articleID, int articleWriter) {
		String sql = "update article set articleWriter = ? where articleID = ?";
	    if( this.jdbcTemplate.update(sql, articleWriter, articleID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeArticleTpye(int articleID, String articleType) {
		String sql = "update article set userName = ? where articleID = ?";
	    if( this.jdbcTemplate.update(sql, articleType, articleID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean changeArticleAddress(int articleID, String articleAddress) {
		String sql = "update article set userName = ? where articleID = ?";
	    if( this.jdbcTemplate.update(sql, articleAddress, articleID) != 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public int getArticleID(String articleName) {
		String sql = "select articleID from article where articleName = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, articleName);
	}

	@Override
	public String getArticleName(int articleID) {
		String sql = "select articleName from article where articleID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, articleID);
	}

	@Override
	public int getArticleWriterID(int articleID) {
		String sql = "select articleWriter from article where articleID = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, articleID);
	}

	@Override
	public String getArticleTpye(int articleID) {
		String sql = "select articleType from article where articleID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, articleID);
	}

	@Override
	public String getArticleAddress(int articleID) {
		String sql = "select articleAddress from article where articleID = ?";
		return this.jdbcTemplate.queryForObject(sql, String.class, articleID);
	}

	@Override
	public boolean deleteArticle(int articleID) {
		String sql="delete from article where id=?";
		if(jdbcTemplate.update(sql, articleID) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
