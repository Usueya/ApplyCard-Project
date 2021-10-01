package com.risingsun.mycard.service;

import com.risingsun.mycard.dto.Bill;
import com.risingsun.mycard.dto.Crd;
import com.risingsun.mycard.dto.Cust;
import com.risingsun.mycard.dto.Rcvappl;

public interface ApplyService {
	public void insertFirst(Rcvappl rcvappl, Cust cust, Bill bill, Crd crd);
	public void insertAdd(Rcvappl rcvappl, Cust cust, Bill bill, Crd crd);
	public void insertReissue(Rcvappl rcvappl, Cust cust, Crd crd);
}
