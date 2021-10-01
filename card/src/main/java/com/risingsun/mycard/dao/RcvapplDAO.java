package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import com.risingsun.mycard.dto.Condition;
import com.risingsun.mycard.dto.Rcvappl;

public interface RcvapplDAO {
	public void insert(Rcvappl rcvappl);
	public Rcvappl selectOne(Map<String, String> param);
	public List<Rcvappl> selectList(Condition condition);
}
