package com.risingsun.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.my.dao.ComCodeDAO;
import com.risingsun.my.dto.ComCode;

@Service
public class ComCodeServiceImpl implements ComCodeService{
	
	@Autowired
	ComCodeDAO comCodeDAO;

	@Override
	public List<ComCode> comCodeList(String codeType) {
		return comCodeDAO.comCodeList(codeType);
	}

}
