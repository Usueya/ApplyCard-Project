package com.risingsun.my.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risingsun.my.dao.UserInfoDAO;
import com.risingsun.my.dto.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	UserInfoDAO userInfoDAO;

	@Override
	public void join(UserInfo userInfo) {
		userInfoDAO.join(userInfo);
	}

	@Override
	public UserInfo selectOne(String userId) {
		return userInfoDAO.selectOne(userId);
	}

	@Override
	public Map<String, Object> login(String userId, String userPw) {
		
		//Map:rcode(0/1/2), msg(성공/아이디미존재/비밀번호불일치)
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int rcode = 0;
		String msg = "";
		
		UserInfo user = userInfoDAO.selectOne(userId);
		if(user == null) {
			rcode = 1;
			msg = "미가입된 아이디";
		}else {
			if(userPw.equals(user.getUserPw())) {
				rcode = 0;
				msg = "로그인 완료";
			}else {
				rcode = 2;
				msg = "비밀번호 불일치";
			}
		}
		
		resultMap.put("rcode", rcode);
		resultMap.put("msg", msg);
		
		return resultMap;
	}

	
}
