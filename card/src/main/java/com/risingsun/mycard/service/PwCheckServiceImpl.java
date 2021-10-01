package com.risingsun.mycard.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class PwCheckServiceImpl implements PwCheckService{
	
	public static final String p5 = "(\\w)\\1\\1";
	
	String scrt_no;
	String hdp_no;
	String birth_d;
	Matcher match;
	 
	//연속된 숫자 1111, 1234...
	Pattern pNumber = Pattern.compile("[0-9]");
	
	//생년월일과 동일한 숫자

	@Override
	public boolean pwCheck(Map<String, String> param) {
		scrt_no = param.get("scrt_no");
		hdp_no = param.get("hdp_no");
		birth_d = param.get("birth_d");
		
		return false;
	}
	
	//핸드폰번호 앞, 뒤 4자리와 동일한 숫자
	public boolean sameHdp_no(String scrt_no, String hdp_no) {
		for(int i=0; i<scrt_no.length()-3; i++) {
			if(hdp_no.contains(scrt_no.substring(i, i+3))) {
			return true;
			}
		}
		return false;
	}
	
	//연속 숫자
	public boolean continuousPwd(String scrt_no) {
		int o = 0;
		int d = 0;
		int p = 0;
		int n = 0;
		int limit = 3;
		
		for(int i=0; i<scrt_no.length(); i++) {
			char tempVal = scrt_no.charAt(i);
			if(i > 0 && (p = o - tempVal) > -2 && (n = p == d ? n + 1 :0) > limit -3) {
				return true;
			}
			d = p;
			o = tempVal;
		}
		return false;
	}
	
	//같은 숫자
	public boolean samePwd(String scrt_no) {
		match = Pattern.compile(p5).matcher(scrt_no);
		return match.find() ? true : false;
	}

}
