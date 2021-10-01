package com.risingsun.my.dao;

import com.risingsun.my.dto.UserInfo;

public interface UserInfoDAO {
	
	public void join(UserInfo userInfo);
	public UserInfo selectOne(String userId);

}
