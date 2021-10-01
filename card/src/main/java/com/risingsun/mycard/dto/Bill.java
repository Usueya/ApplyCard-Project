package com.risingsun.mycard.dto;

import lombok.Data;

@Data
public class Bill {
	private String stl_act;
	private String bnk_cd;
	private String dps_nm;
	private String stl_mtd;
	private String stl_dd;
	private String cust_no;
	private String prcs_clas;
	private String stmt_snd_mtd;
	private String stmt_deni_clas;
	private String billadr_zip;
	private String billadr_adr1;
	private String billadr_adr2;
	private String email_adr;
	private String lst_opr_tm;
	private String lst_opr_d;
	private String lst_oprt_empno;
}
