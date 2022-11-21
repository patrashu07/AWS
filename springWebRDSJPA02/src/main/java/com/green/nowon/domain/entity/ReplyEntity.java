package com.green.nowon.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(exclude = "board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_seq_reply",sequenceName = "seq_reply",initialValue = 1,allocationSize = 1 )
@Entity
public class ReplyEntity {
	@Id
	@GeneratedValue(generator = "gen_seq_reply" , strategy =GenerationType.SEQUENCE)
	private int rno;
	@Column(nullable = false)
	private String text;
	private String writer;
	@CreationTimestamp
	private LocalDateTime createdDate;
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
//--------------------------------------------------------//	
	//n:1 == 관계설정 . 이론적으로는 모두 일대다 .
	//외래키 생성 i: 다( 쪽에생긴다)
	//@JoinColumn(name = "bno") //fk 컬럼명 이름 설정
	//@ManyToOne
	//BoardEntity board; 
	//외래키작성 jap의 특징 OOP사용가능 
	//fk 컬럼명 
//--------------------------------------------------------//
	//양방향설정시
	
	
	//@JoinColumn
	//@OneToMany(mappedBy = "board") //mappedBy를 이용해서 owns(필드값을 넣어달라)에서 만들어주는 fk같이 사용한다  
	//List<ReplyEntity> replies; // 연계테이블을 만들서쓰고
	
	
	
		@JoinColumn(nullable = false)
		@ManyToOne 
		BoardEntity board; 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
