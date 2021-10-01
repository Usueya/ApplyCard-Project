package com.risingsun.my.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.risingsun.my.dto.ComCode;

public interface ComCodeService {
	public List<ComCode> comCodeList(String codeType);
}
