package com.risingsun.mycard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.risingsun.mycard.dao.NoseqtblDAO;
import com.risingsun.mycard.dao.RcvapplDAO;
import com.risingsun.mycard.dao.SeqnotblDAO;
import com.risingsun.mycard.dto.Rcvappl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class NoseqtblTest {
	
	@Autowired
	NoseqtblDAO noseqtblDAO;
	
	@Autowired 
	SeqnotblDAO seqnotblDAO;
	
	@Autowired
	RcvapplDAO rcvapplDAO;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void noseqtblTest() {
		Map<String, String> param = new HashMap<String, String>();
		param.put("ssn", "911127");
		param.put("rcv_d", "20210917");
		rcvapplDAO.selectOne(param);
		System.out.println(rcvapplDAO.selectOne(param));
	}
	
	@Test
	public void noseqtblTest2() {
		Map<String, String> param = new HashMap<String, String>();
		sqlSession.selectOne("com.risingsun.my.SeqnotblMapper.getCust_no", param);
		System.out.println(param.toString());
	}
	
	@Test
	public void listTest() {
		 List<Rcvappl> list = sqlSession.selectList("com.risingsun.my.RcvapplMapper.selectList");
		System.out.println(list.toString());
	}
	
	@Test
	public void applyTest() {
		Map<String, String> param = new HashMap<String, String>();
		param.put("ssn", "9111282151902");
		param.put("rcv_d", "20210923");
		param.put("rcv_seq_no", "8");
		
		Rcvappl rcvallp = rcvapplDAO.selectOne(param);
		System.out.println(rcvallp.toString());
	}
	
	@Test
	public void custTest() {
		Map<String, String> param = new HashMap<String, String>();
		param.put("hg_nm", "");
		param.put("birth_d", "");
		param.put("hdp_no", "");
		
		List<Map<String, String>> list 
			= sqlSession.selectList("com.risingsun.my.CustMapper.selectList", param);
		
		System.out.println(list.toString());
	}
	
	

}
