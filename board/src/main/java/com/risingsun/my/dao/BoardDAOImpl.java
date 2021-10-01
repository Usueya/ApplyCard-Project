package com.risingsun.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risingsun.my.dto.Board;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Board board) {
		sqlSession.insert("com.risingsun.my.BoardMapper.insert",board);
	}

	@Override
	public void update(Board board) {
		sqlSession.update("com.risingsun.my.BoardMapper.update",board);
		
	}

	@Override
	public void delete(int boardNum) {
		sqlSession.delete("com.risingsun.my.BoardMapper.delete",boardNum);
	}

	@Override
	public Board selectOne(int boardNum) {
		return sqlSession.selectOne("com.risingsun.my.BoardMapper.selectOne",boardNum);
	}

	@Override
	public List<Board> selectList() {
		return sqlSession.selectList("com.risingsun.my.BoardMapper.selectList");
	}
	

}
