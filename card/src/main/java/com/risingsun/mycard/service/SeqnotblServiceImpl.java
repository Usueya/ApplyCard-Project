package com.risingsun.mycard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dao.SeqnotblDAO;

@Service
public class SeqnotblServiceImpl implements SeqnotblService{
	
	@Autowired
	SeqnotblDAO seqnotbleDAO;
	
	@Override
	public String getCust_no() {
		return seqnotbleDAO.getCust_no();
	}

	@Override
	public String getCrd_no(String brd) {
		String crd_no = seqnotbleDAO.getCrd_no();
		
		if(brd.equals("1")) {
			crd_no = "531011"+crd_no;
		}else if(brd.equals("2")) {
			crd_no = "490611"+crd_no;
		}else if(brd.equals("3")) {
			crd_no = "356011"+crd_no;
		}
		return crd_no;
	}


}
