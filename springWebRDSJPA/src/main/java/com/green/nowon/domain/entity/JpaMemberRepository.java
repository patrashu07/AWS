package com.green.nowon.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMemberRepository extends JpaRepository<JpaMember, Long> {
														//Entity 클래스명 , pk의 컬럼의 데이터타입 Integer , Long ,등등 으로 넣자 
													    //기본형데이터불가(string long int등등 ) 랩퍼클래스로설정
}
