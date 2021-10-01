package com.risingsun.mycard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.mycard.dao.NoseqtblDAO;

@Service
public class NoseqtblServiceImpl implements NoseqtblService{
	
	@Autowired
	NoseqtblDAO noseqDAO;

	@Override
	public String getRcv_seq_no() {
		return noseqDAO.getRcv_seq_no();
	}

	@Override
	public void insertRcv_seq_no() {
		noseqDAO.insertRcv_seq_no();
	}

	@Override
	public String selectRcv_seq_no() {
		return noseqDAO.selectRcv_seq_no();
	}

	@Override
	public void updateRcv_seq_no() {
		noseqDAO.updateRcv_seq_no();
	}

}
