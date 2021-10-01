package com.risingsun.mycard.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SeqnotblDAOImpl implements SeqnotblDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public String getCust_no() {
		Map<String, String> param = new HashMap<String, String>();
		sqlSession.selectOne("com.risingsun.my.SeqnotblMapper.getCust_no", param);
		return param.get("pcustno");
	}

	@Override
	public String getCrd_no() {
		Map<String, String> param = new HashMap<String, String>();
		sqlSession.selectOne("com.risingsun.my.SeqnotblMapper.getCrd_no",param);
		return param.get("pcrdno");
	}

	@Override
	public void updateCust_no() {
		sqlSession.selectOne("com.risingsun.my.SeqnotblMapper.getCust_no");
	}

	@Override
	public void updateCrd_no() {
		sqlSession.selectOne("com.risingsun.my.SeqnotblMapper.getCust_no");
	}

}
