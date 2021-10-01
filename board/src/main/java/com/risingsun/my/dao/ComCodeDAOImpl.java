package com.risingsun.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.my.dto.ComCode;

@Repository
public class ComCodeDAOImpl implements ComCodeDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ComCode> comCodeList(String codeType) {
		List<ComCode> list =  sqlSession.selectList("com.risingsun.my.ComCodeMapper.comCodeList",codeType);
		System.out.println(list);
		return list;
	}

}
