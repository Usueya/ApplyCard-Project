package com.risingsun.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.my.dao.BoardDAO;
import com.risingsun.my.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public void insert(Board board) {
		boardDAO.insert(board);
		
	}

	@Override
	public void update(Board board) {
		boardDAO.update(board);
		
	}

	@Override
	public void delete(int boardNum) {
		boardDAO.delete(boardNum);
		
	}

	@Override
	public Board selectOne(int boardNum) {
		return boardDAO.selectOne(boardNum);
	}

	@Override
	public List<Board> selectList() {
		return boardDAO.selectList();
	}

}
