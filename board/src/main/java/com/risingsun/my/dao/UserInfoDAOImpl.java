package com.risingsun.my.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.my.dto.UserInfo;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void join(UserInfo userInfo) {
		System.out.println("DAO"+userInfo);
		sqlSession.insert("com.risingsun.my.UserInfoMapper.join",userInfo);
	}

	@Override
	public UserInfo selectOne(String userId) {
		return sqlSession.selectOne("com.risingsun.my.UserInfoMapper.selectOne",userId);
	}

}
