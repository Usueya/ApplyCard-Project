package com.risingsun.mycard.service;

import java.util.List;
import java.util.Map;

import com.risingsun.mycard.dto.CommCodeDtl;

public interface CommCodeDtlService {
	public List<CommCodeDtl> selectList();
	public CommCodeDtl getComm_code_dtl(String group_cd, String code);
}
