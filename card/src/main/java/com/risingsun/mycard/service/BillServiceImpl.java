package com.risingsun.mycard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dao.BillDAO;
import com.risingsun.mycard.dto.Bill;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillDAO billDAO;
	
	@Override
	public void insert(Bill bill) {
		billDAO.insert(bill);
	}

	@Override
	public void update(Bill bill) {
		billDAO.update(bill);
	}

}
