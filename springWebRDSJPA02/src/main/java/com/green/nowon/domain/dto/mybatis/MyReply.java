package com.green.nowon.domain.dto.mybatis;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyReply {

	private long bno;
	private long rno;
	private String text;
	private String writer;
		private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
}
