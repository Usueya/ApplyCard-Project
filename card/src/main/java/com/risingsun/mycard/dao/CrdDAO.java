package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import com.risingsun.mycard.dto.Crd;

public interface CrdDAO {
	public void insert(Crd crd);
	public Crd selectOne(Crd crd);
	public void updateBf(Crd crd);
	public void insertReissue(Crd crd);
	public List<Crd> selectList(Map<String, String> map);
	public Crd selectDetail(Map<String, String> map);
}
