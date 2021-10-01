package com.risingsun.mycard.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoseqtblDAOImpl implements NoseqtblDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public String getRcv_seq_no() {
		Map<String, String> param = new HashMap<String, String>();
		 sqlSession.selectList("com.risingsun.my.NoseqtblMapper.getRcv_seq_no", param);
		 return param.get("pseqno");
	}
	
	@Override
	public void insertRcv_seq_no() {
		sqlSession.insert("com.risingsun.my.NoseqtblMapper.insertRcv_seq_no");
	}

	@Override
	public String selectRcv_seq_no() {
		return sqlSession.selectOne("com.risingsun.my.NoseqtblMapper.selectRcv_seq_no");
	}

	@Override
	public void updateRcv_seq_no() {
		sqlSession.update("com.risingsun.my.NoseqtblMapper.updateRcv_seq_no");
		
	}


	

}
