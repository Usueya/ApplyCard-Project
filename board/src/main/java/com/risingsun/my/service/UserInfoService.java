package com.risingsun.my.service;

import java.util.Map;

import com.risingsun.my.dto.UserInfo;

public interface UserInfoService {
	
	public void join(UserInfo userInfo);
	public UserInfo selectOne(String userId);
	public Map<String, Object> login(String userId, String userPw);

}
