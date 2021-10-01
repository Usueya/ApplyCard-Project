package com.risingsun.mycard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dao.CustDAO;
import com.risingsun.mycard.dto.Cust;

@Service
public class CustSerivceImpl implements CustSerivce{

	@Autowired
	CustDAO custDAO;
	
	@Override
	public void insert(Cust cust) {
		custDAO.insert(cust);
	}

	@Override
	public Cust selectOne(String ssn) {
		return custDAO.selectOne(ssn);
	}

	@Override
	public void update(Cust cust) {
		custDAO.update(cust);
	}

	@Override
	public List<Map<String, String>> selectList(Map<String, String> param) {
		return custDAO.selectList(param);
	}

	@Override
	public Map<String, String> selectOneBill(String ssn) {
		return custDAO.selectOneBill(ssn);
	}

}
