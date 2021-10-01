package com.risingsun.mycard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.risingsun.mycard.dto.Bill;
import com.risingsun.mycard.dto.CommCodeDtl;
import com.risingsun.mycard.dto.Condition;
import com.risingsun.mycard.dto.Crd;
import com.risingsun.mycard.dto.Cust;
import com.risingsun.mycard.dto.Rcvappl;
import com.risingsun.mycard.service.ApplyService;
import com.risingsun.mycard.service.CommCodeDtlService;
import com.risingsun.mycard.service.RcvapplService;
import com.risingsun.mycard.service.UnableService;

@Controller
public class ApplyController {

	@Autowired private CommCodeDtlService commCodeDtlService;
	@Autowired private ApplyService applyService;
	@Autowired private UnableService unablSerivce;
	@Autowired private RcvapplService rcvapplService;
	
	//회원입회신청폼이동
	@GetMapping("apply")
	public String applyForm(Model model) {
		 List<CommCodeDtl> commCodelist = commCodeDtlService.selectList();
		 model.addAttribute("commCodelist", commCodelist);
		return "apply";
	}
	
	//입회신청상세조회
	@GetMapping("findApply")
	public String moveFindApply(@RequestParam Map<String, String> param, Model model) {
		List<CommCodeDtl> commCodelist = commCodeDtlService.selectList();
		model.addAttribute("commCodelist", commCodelist);
		 
		Rcvappl rcvappl = rcvapplService.selectOne(param);
		model.addAttribute("rcvappl", rcvappl);
		return "apply";
	}
	
	//입회신청조회
	@ResponseBody
	@PostMapping("findApply")
	public Rcvappl showFindApply(@RequestParam Map<String, String> param) {
		Rcvappl rcvappl = rcvapplService.selectOne(param);
		return rcvappl;
	}
	
	//회원입회신청
	@PostMapping("apply")
	public String applyRcvappl(Rcvappl rcvappl, Cust cust, Bill bill, Crd crd) {
		String appl_clas = rcvappl.getAppl_clas(); //신청구분
		
		if(appl_clas.equals("11")) { //최초신규
			applyService.insertFirst(rcvappl, cust, bill, crd);
		}else if(appl_clas.equals("12")){ //추가신규
			applyService.insertAdd(rcvappl, cust, bill, crd);
		}else if(appl_clas.equals("21")){ //재발급
			applyService.insertReissue(rcvappl, cust, crd);
		}
		return "redirect:/apply";
	}
	
	//불능체크
	@ResponseBody
	@PostMapping("unable")
	public CommCodeDtl unableCheck(@RequestParam Map<String, String> param) {
		CommCodeDtl returnCode = unablSerivce.unableCheck(param);
		return returnCode;
	}
	
	//기간별입회신청내역조회폼
	@GetMapping("applylist")
	public String applylistForm(Model model, Condition condition) {
		List<CommCodeDtl> commCodelist = commCodeDtlService.selectList();
		model.addAttribute("commCodelist", commCodelist);
		
		List<Rcvappl> appllist = rcvapplService.selectList(condition);
		model.addAttribute("appllist", appllist);
		
		model.addAttribute("condition", condition);
		return "applylist";
	}
	

}
