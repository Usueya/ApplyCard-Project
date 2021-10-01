package com.risingsun.mycard.dao;

import java.util.List;
import java.util.Map;

import com.risingsun.mycard.dto.CommCodeDtl;

public interface CommCodeDtlDAO {
	public List<CommCodeDtl> selectList();
	public CommCodeDtl getComm_code_dtl(Map<String, String> param);
}
