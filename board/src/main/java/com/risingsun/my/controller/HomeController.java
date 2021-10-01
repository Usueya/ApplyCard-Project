package com.risingsun.my.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.risingsun.my.service.UserInfoService;

@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserInfoService userInfoService;
	
	//홈화면이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	//로그인화면이동
	@GetMapping("login")
	public String loginForm() {
		return "login";
	}
	
	//로그인기능
	@PostMapping("login")
	public String login(String userId, String userPw, Model model, HttpSession session) {
		Map<String, Object> resultMap = userInfoService.login(userId, userPw);
		
		int rcode = (Integer)resultMap.get("rcode");
		if(rcode == 0) {
			session.setAttribute("userId", userId);
			model.addAttribute("msg", resultMap.get("msg"));
			return "redirect:/board/list";
		}else {
			model.addAttribute("msg", resultMap.get("msg"));
			return "login";
		}
	}
	
	//로그아웃기능
	@GetMapping("logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃되었습니다.");
		return "redirect:/login";
	}
	
}
