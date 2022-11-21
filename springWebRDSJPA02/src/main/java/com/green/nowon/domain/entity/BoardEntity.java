package com.green.nowon.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(exclude = "replies")
@Getter //엔티티에서 데이터를 가져오면 불안정할수있기때문에 게터를 dto를 통해서쓰자
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name ="gen_seq_bo" ,//generate 이름 
				   sequenceName ="seq_bo" ,//시퀀스이름
				   initialValue=1 , //strat widh 1
				   allocationSize =1  )//increment by1	//시퀀스생성 
@Table(name = "JpaBoard") // jpql -> jpa에서 쓰는 sql
@Entity // 물리db 의 테이블과 매핑되는 클래스 : 클래스이름==table이름 ,필드이름(무조건 카멜로!!) ==컬럼명(underscore표기)
public class BoardEntity {// 접속객체 (dao:repository)만들어야도니다.
							// BoardEntityRepository 접속객체

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)// mariadb auto.increment
	@GeneratedValue(generator ="gen_seq_bo", strategy = GenerationType.SEQUENCE) //mariadb / oracle 시퀀스생성 
	private int bno;

	@Column(nullable = false)
	private String tittle;

	// @Column(columnDefinition = "CLUB not null")=?>oracle
	@Column(columnDefinition = "LONGTEXT not null") // mariadb
	// @Column(columnDefinition = "text not null")
	private String content;
	private int readCount;
	private String writer;

	@CreationTimestamp
	@Column(columnDefinition = "timestamp") //mariadb에서 timestamp적용
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime updatedDate;
//--------------------------------------------------------//
    //1대 다수의 관계  1:n 
	//@JoinColumn(name = "bno")//다쪽 테이블에 생성되는 (컬럼명 객체이름_pk)로 생성
	//@OneToMany// 기본적으로 연계테이블을 두 테이블을 join한다.:원하지않은 테이블이 생성될수가있다.
	//연계테이블을 만들기싫으면 joincolumn을 써야한다.
	//List<ReplyEntity> replies;
	//fk 가 생성되지않는곳은 연계테이블에 생성된다.
//--------------------------------------------------------//	
	//양방향설정시
	
	//@JoinColumn있는쪽이 주 엔티티가된다 .fk 
	//@JoinColumn //양방향 관계에서 Many엔티티를 owns엔티티 선언 
	//@ManyToOne //MappedBy가 존재하지않아요
	//BoardEntity board; //fk생성 
	
	
	@OneToMany(mappedBy = "board")
	List<ReplyEntity> replies; //=new Vector<>(); 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
