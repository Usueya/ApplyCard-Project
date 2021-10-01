package com.risingsun.mycard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dao.CrdDAO;
import com.risingsun.mycard.dto.Crd;

@Service
public class CrdServiceImpl implements CrdService{
	
	@Autowired
	CrdDAO crdDAO;
	
	@Override
	public void insert(Crd crd) {
		//이전카드발급정보조회
		Crd resultCrd = crdDAO.selectOne(crd); 
		
		if(resultCrd == null) {
			crdDAO.insert(crd);
		}else {
			crdDAO.updateBf(crd); //이전카드의 최종을 ""으로업데이트
			String bf_crd_no = resultCrd.getCrd_no(); //이전카드번호
			crd.setBf_crd_no(bf_crd_no);
			String fst_reg_d = resultCrd.getFst_reg_d(); //이전카드의최초등록일자
			crd.setFst_reg_d(fst_reg_d);
			crdDAO.insertReissue(crd);
		}
	}
	
	@Override
	public Crd selectOne(Crd crd) {
		return crdDAO.selectOne(crd); 
	}

	@Override
	public List<Crd> selectList(String ssn, String crd_no) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ssn", ssn);
		map.put("crd_no", crd_no);
		return crdDAO.selectList(map);
	}

	@Override
	public Crd selectDetail(String ssn, String crd_no) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ssn", ssn);
		map.put("crd_no", crd_no);
		return crdDAO.selectDetail(map);
	}

}
