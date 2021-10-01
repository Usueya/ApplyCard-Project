package com.risingsun.my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.risingsun.my.dto.Board;
import com.risingsun.my.dto.ComCode;
import com.risingsun.my.service.BoardService;
import com.risingsun.my.service.ComCodeService;


@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	ComCodeService comCodeService;
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("list")
	public void list(Model model) {
		List<ComCode> comCodeList = comCodeService.comCodeList("menu");
		List<Board> boardList = boardService.selectList();
		model.addAttribute("comCodeList", comCodeList);
		model.addAttribute("boardList", boardList);
	}
	
	@GetMapping("detail")
	public void detail(int boardNum, Model model) {
		Board board = boardService.selectOne(boardNum);
		model.addAttribute("board", board);
	}
	
	@GetMapping("update")
	public void updateForm(int boardNum, Model model) {
		Board board = boardService.selectOne(boardNum);
		model.addAttribute("board", board);
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.update(board);
		return "redirect:list";
	}
	
	//게시글작성폼이동
	@GetMapping("write")
	public void writeForm(Model model) {
		List<ComCode> comCodeList = comCodeService.comCodeList("menu");
		model.addAttribute("comCodeList", comCodeList);
	}
	
	//게시글작성
	@PostMapping("write")
	public String write(Board board) {
		boardService.insert(board);
		return "redirect:list";
	}
	

}
