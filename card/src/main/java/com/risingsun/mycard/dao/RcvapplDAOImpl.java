package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.mycard.dto.Condition;
import com.risingsun.mycard.dto.Rcvappl;

@Repository
public class RcvapplDAOImpl implements RcvapplDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Rcvappl rcvappl) {
		sqlSession.insert("com.risingsun.my.RcvapplMapper.insert", rcvappl);
	}

	@Override
	public Rcvappl selectOne(Map<String, String> param) {
		return sqlSession.selectOne("com.risingsun.my.RcvapplMapper.selectOne", param); 
	}

	@Override
	public List<Rcvappl> selectList(Condition condition) {
		return sqlSession.selectList("com.risingsun.my.RcvapplMapper.selectList", condition);
	}

}
