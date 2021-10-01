package com.risingsun.mycard.service;

import java.util.List;
import java.util.Map;

import com.risingsun.mycard.dto.Crd;

public interface CrdService {
	public void insert(Crd crd);
	public Crd selectOne(Crd crd);
	public List<Crd> selectList(String ssn, String crd_no);
	public Crd selectDetail(String ssn, String crd_no);
}
