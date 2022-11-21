package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Table(name= "board") //이걸안만들면 클래스이름이 table 이름이 된다.
//spring.jpa.generate-ddl=true 쿼리는 날린다!!!!
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity // 물리 DB의 테이블을 매핑한 객체 spring.jpa.show-sql=true
public class JpaMember {
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) // value가 자동으로 만들어줍니다
	private long no; // 숫자형 데이터타입인경우 auto_increment 설정가능

	@Column(unique = true, nullable = false) // not null unique
	private String eamil;

	//@Column(columnDefinition = "varchar(255) unique") // 전 잘모르겟어요 이러면 직접 제약조건을 적을수가 있다.
	@Column(unique = true , length =20)
	private String nickName;
	
	@Column(nullable = false) // 전 잘모르겟어요 이러면 직접 제약조건을 적을수가 있다.
								// sql 인덱스란 검색을 빠르게가능하다
	private String password;

	//@CreatedDate
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	//@LastModifiedDate
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	//편의메서드
	public JpaMember updateNickName(String nickName) {
		this.nickName=nickName;
		return this;
		
	}
	
	
	
	// @Id: pk
	// @Column: name="컬럼이름",
//			   unique    = true|false 유니크 여부
//			   nullable  = true|false null 허용여부
//			   insertable= true|false insert가능여부
//			   updateable= true|false 수정가능여부
//	   	       length = int default=255  컬럼 사이즈
}
