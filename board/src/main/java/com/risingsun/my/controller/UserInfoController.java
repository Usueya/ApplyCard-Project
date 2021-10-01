package com.risingsun.my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.risingsun.my.dto.ComCode;
import com.risingsun.my.dto.UserInfo;
import com.risingsun.my.service.ComCodeService;
import com.risingsun.my.service.UserInfoService;

@Controller
@RequestMapping("userinfo")
public class UserInfoController {

	@Autowired
	private ComCodeService comCodeService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	//회원가입화면이동
	@GetMapping("join")
	public String joinForm(Model model) {
		List<ComCode> comCodeList = comCodeService.comCodeList("phone");
		model.addAttribute("comCodeList", comCodeList);
		return "join";
	}
	
	//아이디중복체크
	@ResponseBody
	@GetMapping(value = "idCheck/{userId}", produces = "application/text; charset=utf-8")
	public String idCheck(@PathVariable("userId") String userId) {
		UserInfo resultUser = userInfoService.selectOne(userId);
		if(resultUser == null) {
			return "Y"; //사용가능한ID
		}else {
			return "N"; //중복된 ID
		}
	}
	
	//회원정보저장
	@PostMapping("join")
	public String join(UserInfo userInfo) {
		userInfoService.join(userInfo);
		return "redirect:/login";
	}
	

}
