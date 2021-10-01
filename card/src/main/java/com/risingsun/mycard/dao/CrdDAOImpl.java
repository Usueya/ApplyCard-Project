package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.mycard.dto.Crd;

@Repository
public class CrdDAOImpl  implements CrdDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Crd crd) {
		sqlSession.insert("com.risingsun.my.CrdMapper.insert",crd);
	}

	@Override
	public Crd selectOne(Crd crd) {
		return sqlSession.selectOne("com.risingsun.my.CrdMapper.selectOne",crd);
	}

	@Override
	public void updateBf(Crd crd) {
		sqlSession.update("com.risingsun.my.CrdMapper.updateBf",crd);
	}

	@Override
	public void insertReissue(Crd crd) {
		sqlSession.insert("com.risingsun.my.CrdMapper.insertReissue",crd);
	}

	@Override
	public List<Crd> selectList(Map<String, String> map) {
		return sqlSession.selectList("com.risingsun.my.CrdMapper.selectList",map);
	}

	@Override
	public Crd selectDetail(Map<String, String> map) {
		return sqlSession.selectOne("com.risingsun.my.CrdMapper.selectDetail",map);
	}

}
