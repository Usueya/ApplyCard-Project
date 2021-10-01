package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.mycard.dto.Cust;

@Repository
public class CustDAOImpl implements CustDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(Cust cust) {
		sqlSession.insert("com.risingsun.my.CustMapper.insert", cust);
	}

	@Override
	public Cust selectOne(String ssn) {
		return sqlSession.selectOne("com.risingsun.my.CustMapper.selectOne", ssn);
	}

	@Override
	public void update(Cust cust) {
		sqlSession.update("com.risingsun.my.CustMapper.update", cust);
	}

	@Override
	public List<Map<String, String>> selectList(Map<String, String> param) {
		return sqlSession.selectList("com.risingsun.my.CustMapper.selectList", param);
	}

	@Override
	public Map<String, String> selectOneBill(String ssn) {
		return sqlSession.selectOne("com.risingsun.my.CustMapper.selectOneBill", ssn);
	}

}
