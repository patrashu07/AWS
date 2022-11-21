package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import com.green.nowon.domain.entity.BoardEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BoardListDTO {

	private int bno;
	private String tittle;
	private int readCount;
	private String writer;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	// 편의생성자 entity가 매개변수로 하는 생성자
	public BoardListDTO(BoardEntity e) {
		bno = e.getBno();
		tittle = e.getTittle();
		readCount = e.getReadCount();
		writer = e.getWriter();
		createdDate = e.getCreatedDate();
		updatedDate = e.getUpdatedDate();
	}
	
	public void initOfEntity(BoardEntity e) {
		bno = e.getBno();
		tittle = e.getTittle();
		readCount = e.getReadCount();
		writer = e.getWriter();
		createdDate = e.getCreatedDate();
		updatedDate = e.getUpdatedDate();
	}

}
