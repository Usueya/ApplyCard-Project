package com.risingsun.my.dao;

import java.util.List;

import com.risingsun.my.dto.Board;

public interface BoardDAO {
	
	public void insert(Board board);
	public void update(Board board);
	public void delete(int boardNum);
	public Board selectOne(int boardNum);
	public List<Board> selectList();

}
