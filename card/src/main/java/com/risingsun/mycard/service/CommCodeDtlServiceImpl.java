package com.risingsun.mycard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dao.CommCodeDtlDAO;
import com.risingsun.mycard.dto.CommCodeDtl;

@Service
public class CommCodeDtlServiceImpl implements CommCodeDtlService{
	
	@Autowired
	CommCodeDtlDAO commCodeDtlDAO;

	@Override
	public List<CommCodeDtl> selectList() {
		return commCodeDtlDAO.selectList();
	}

	@Override
	public CommCodeDtl getComm_code_dtl(String group_cd, String code) {
		Map<String, String> findComm_code_dtl = new HashMap<String, String>();
		findComm_code_dtl.put("group_cd", group_cd);
		findComm_code_dtl.put("code", code);
		return commCodeDtlDAO.getComm_code_dtl(findComm_code_dtl);
	}

}
