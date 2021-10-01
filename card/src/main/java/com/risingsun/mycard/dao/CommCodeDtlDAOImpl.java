package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.mycard.dto.CommCodeDtl;

@Repository
public class CommCodeDtlDAOImpl implements CommCodeDtlDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<CommCodeDtl> selectList() {
		return sqlSession.selectList("com.risingsun.my.CommCodeDtlMapper.selectList");
	}

	@Override
	public CommCodeDtl getComm_code_dtl(Map<String, String> param) {
		return sqlSession.selectOne("com.risingsun.my.CommCodeDtlMapper.selectOne", param);
	}

}
