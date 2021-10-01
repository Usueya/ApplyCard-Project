package com.risingsun.mycard.service;

import java.util.Map;

import com.risingsun.mycard.dto.CommCodeDtl;

public interface UnableService {
	public CommCodeDtl unableCheck(Map<String, String> param);
	public CommCodeDtl applyCheck(Map<String, String> param);
}
