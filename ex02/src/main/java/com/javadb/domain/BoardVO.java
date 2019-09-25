package com.javadb.domain;

import java.util.Date;

import lombok.Data;		// getter, setter, toString()을 자동생성해줌

@Data
public class BoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate; 
}
