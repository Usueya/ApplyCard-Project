package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import com.risingsun.mycard.dto.Cust;

public interface CustDAO {
	public void insert(Cust cust);
	public Cust	selectOne(String ssn);
	public void update(Cust cust);
	public List<Map<String, String>> selectList(Map<String, String> param);
	public Map<String, String> selectOneBill(String ssn);
}
