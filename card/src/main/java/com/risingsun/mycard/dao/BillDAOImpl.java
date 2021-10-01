package com.risingsun.mycard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.mycard.dto.Bill;

@Repository
public class BillDAOImpl implements BillDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Bill bill) {
		sqlSession.insert("com.risingsun.my.BillMapper.insert", bill);
	}

	@Override
	public void update(Bill bill) {
		sqlSession.update("com.risingsun.my.BillMapper.update", bill);
	}

}
