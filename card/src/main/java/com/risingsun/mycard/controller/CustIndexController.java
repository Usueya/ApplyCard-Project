package com.risingsun.mycard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.risingsun.mycard.dto.Crd;
import com.risingsun.mycard.service.CrdService;
import com.risingsun.mycard.service.CustSerivce;

@Controller
public class CustIndexController {
	
	@Autowired private CustSerivce custService;
	@Autowired private CrdService crdService;
	
	//회원색인조회폼
	/*
	 * @GetMapping("custlist") public String custlistForm() { return "custlist"; }
	 */
	
	//회원색인조회폼
	@RequestMapping("custlist")
	public String custlist(@RequestParam Map<String, String> param
							,Model model) {
		List<Map<String, String>> list = custService.selectList(param);
		model.addAttribute("list", list);
		model.addAttribute("param", param);
		return "custlist";
	}
	
	//소지카드내역조회폼
	@GetMapping("cardlist")
	public String cardlistForm(Model model, String ssn, String crd_no) {
		Map<String, String> cust = custService.selectOneBill(ssn);
		model.addAttribute("cust", cust);
		List<Crd> crdlist = crdService.selectList(ssn, crd_no);
		model.addAttribute("crdlist", crdlist);
		return "cardlist";
	}
	
	//카드상세내역폼
	@GetMapping("carddetail")
	public String carddetailForm(Model model, String ssn, String crd_no) {
		Crd crd = crdService.selectDetail(ssn, crd_no);
		model.addAttribute("crd", crd);
		return "carddetail";
	}

}
