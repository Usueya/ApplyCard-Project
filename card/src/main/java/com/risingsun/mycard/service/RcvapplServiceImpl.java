package com.risingsun.mycard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dao.RcvapplDAO;
import com.risingsun.mycard.dto.Condition;
import com.risingsun.mycard.dto.Rcvappl;

@Service
public class RcvapplServiceImpl implements RcvapplService{
	
	@Autowired
	RcvapplDAO rcvapplDAO;

	@Override
	public void insert(Rcvappl rcvappl) {
		rcvapplDAO.insert(rcvappl);
	}

	@Override
	public Rcvappl selectOne(Map<String, String> param) {
		return rcvapplDAO.selectOne(param);
	}

	@Override
	public List<Rcvappl> selectList(Condition condition) {
		return rcvapplDAO.selectList(condition);
	}

}
