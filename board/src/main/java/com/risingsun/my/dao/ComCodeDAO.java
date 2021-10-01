package com.risingsun.my.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.risingsun.my.dto.ComCode;

public interface ComCodeDAO {
	public List<ComCode> comCodeList(String codeType);
}
