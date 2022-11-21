package com.green.nowon.domain.dto.mybatis;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter //html page-> el로 데이터를 표현하기위해서
@Setter //page-> controller의 파라미터 매핑을 위해 필요
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyBoardDTO {
	 
	private long bno;
	private String title;
	private String content;
	private int readCount;
	private String writer;
	private LocalDateTime updatedDate;
	private LocalDateTime createdDate;
}
