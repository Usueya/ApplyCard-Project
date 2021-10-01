package com.risingsun.mycard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.risingsun.mycard.dto.Bill;
import com.risingsun.mycard.dto.Crd;
import com.risingsun.mycard.dto.Cust;
import com.risingsun.mycard.dto.Rcvappl;

@Repository
public class ApplyServiceImpl implements ApplyService{
	
	@Autowired
	RcvapplService rcvapplService;
	
	@Autowired
	CustSerivce custService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	CrdService crdService;
	
	@Autowired
	SeqnotblService seqnotblService;
	
	@Autowired
	NoseqtblService noseqtblService;

	//최초신규
	@Override
	@Transactional
	public void insertFirst(Rcvappl rcvappl, Cust cust, Bill bill, Crd crd) {
		
		String cust_no = seqnotblService.getCust_no();//고객번호발번
		String crd_no = seqnotblService.getCrd_no(rcvappl.getBrd());//카드번호발번
		String rcv_seq_no = noseqtblService.getRcv_seq_no();//접수일련번호발번
		
		//신청테이블입력
		rcvappl.setCrd_no(crd_no);
		rcvappl.setRcv_seq_no(rcv_seq_no);
		rcvapplService.insert(rcvappl);
		
		//고객테이블입력
		cust.setCust_no(cust_no);
		custService.insert(cust);
		
		//결제테이블입력
		bill.setCust_no(cust_no);
		bill.setDps_nm(rcvappl.getHg_nm());
		billService.insert(bill); 
		
		//카드테이블입력
		crd.setCust_no(cust_no);
		crd.setCrd_no(crd_no);
		crdService.insert(crd);
		
	}
	
	//추가신규
	@Override
	@Transactional
	public void insertAdd(Rcvappl rcvappl, Cust cust, Bill bill, Crd crd) {
		
		String rcv_seq_no = noseqtblService.getRcv_seq_no();//접수일련번호발번
		String crd_no = seqnotblService.getCrd_no(rcvappl.getBrd());//카드번호발번
		
		//고객번호가져오기
		Cust resultCust = custService.selectOne(rcvappl.getSsn());
		String cust_no = resultCust.getCust_no();
		
		//신청테이블입력
		rcvappl.setCrd_no(crd_no);
		rcvappl.setRcv_seq_no(rcv_seq_no);
		rcvapplService.insert(rcvappl);
		
		//카드테이블입력
		crd.setCust_no(cust_no);
		crd.setCrd_no(crd_no);
		crdService.insert(crd);
		
		//고객테이블업데이트
		cust.setCust_no(cust_no);
		custService.update(cust);
		
		//결제테이블업데이트
		bill.setCust_no(cust_no);
		bill.setDps_nm(rcvappl.getHg_nm());
		billService.update(bill);
		
	}

	//재발급
	@Override
	@Transactional
	public void insertReissue(Rcvappl rcvappl, Cust cust, Crd crd) {
		
		String crd_no = seqnotblService.getCrd_no(rcvappl.getBrd());//카드번호발번
		String rcv_seq_no = noseqtblService.getRcv_seq_no();//접수일련번호발번
		
		//신청테이블입력
		rcvappl.setCrd_no(crd_no);
		rcvappl.setRcv_seq_no(rcv_seq_no);
		rcvapplService.insert(rcvappl);
		
		//고객번호가져오기
		Cust resultCust = custService.selectOne(rcvappl.getSsn());
		String cust_no = resultCust.getCust_no();
		
		//고객테이블업데이트
		cust.setCust_no(cust_no);
		custService.update(cust);
		
		//카드테이블입력
		crd.setCust_no(cust_no);
		crd.setCrd_no(crd_no);
		crdService.insert(crd);
	}

}
