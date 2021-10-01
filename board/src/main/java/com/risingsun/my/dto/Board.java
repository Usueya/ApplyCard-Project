package com.risingsun.my.dto;

import lombok.Data;

@Data
public class Board {
	private String boardType;
	private int boardNum;
	private String boardTitle;
	private String boardComment;
	private String creator;
	private String createTime;
	private String modifier;
	private String modifiedTime;
	private String fileRoot;
	
	private String codeName;
}
