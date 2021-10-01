package com.risingsun.mycard.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProcDTO {
	private String rcv_d;
	private String rcv_seq_no;
	private String seqno;
	
	private List<Noseqtbl> list;

}
