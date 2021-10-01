package com.risingsun.mycard.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dto.CommCodeDtl;
import com.risingsun.mycard.dto.Crd;

@Service
public class UnableServiceImpl implements UnableService{
	
	@Autowired private RcvapplService rcvapplService;
	@Autowired private CommCodeDtlService commCodeDtlService;
	@Autowired private CustSerivce custService;
	@Autowired private CrdService crdService;
	
	private String ssn;
	private String brd;
	private String appl_clas;
	
	@Override
	public CommCodeDtl unableCheck(Map<String, String> param) {
		 ssn = param.get("ssn");
		 brd =param.get("brd");
		 appl_clas =param.get("appl_clas");
		 
		//불능체크 및 불능코드 반환
		if(applyCheck(param) != null) {
			return applyCheck(param);
			
		}else if(actCheck() != null) {
			return actCheck();
			
		}else if(!appl_clas.equals("21")) {
			if(crdCheck() != null) return crdCheck();
			
		}else if(appl_clas.equals("21")) {
			if(issueCrdCheck() != null) return issueCrdCheck();
		}
		return null;
	}
	
	//당일신청내역조회(01)
	public CommCodeDtl applyCheck(Map<String, String> param) {
		CommCodeDtl commCode = commCodeDtlService.getComm_code_dtl("C001","01");
		if(rcvapplService.selectOne(param) != null) return commCode;
		return null;
	}
	
	//결제계좌오류확인(02)
	public CommCodeDtl actCheck() {
		CommCodeDtl commCode = commCodeDtlService.getComm_code_dtl("C001","02");
		return null;
	}
	
	//비밀번호오류확인(03)
	public CommCodeDtl pwCheck(Map<String, String> param) {
		CommCodeDtl commCode = commCodeDtlService.getComm_code_dtl("C001","03");
		return null;
	}
	
	//최초신규,추가신규의 기존카드존재유무(04)
	public CommCodeDtl crdCheck() {
		CommCodeDtl commCode = commCodeDtlService.getComm_code_dtl("C001","04");
		
		if(appl_clas.equals("11")) {
			if(custService.selectOne(ssn) != null) return commCode;

		}else if(appl_clas.equals("12")){
			if(custService.selectOne(ssn) == null) return commCode;
			
			Crd findCrd = new Crd();
			findCrd.setCust_no(custService.selectOne(ssn).getCust_no());
			findCrd.setBrd(brd);
			if(crdService.selectOne(findCrd) != null) return commCode;
		}
		return null;
	}
	
	//기존카드미존재(05)
	public CommCodeDtl issueCrdCheck() {
		CommCodeDtl commCode = commCodeDtlService.getComm_code_dtl("C001","05");
		
		Crd findCrd = new Crd();
		findCrd.setCust_no(custService.selectOne(ssn).getCust_no());
		findCrd.setBrd(brd);
		
		if(crdService.selectOne(findCrd) == null) {
			return commCode;
		}else {
			return null;
		}
		
	}
}
