package com.green.nowon.domain.entity;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyEntityRepository extends JpaRepository<ReplyEntity, Integer> {
	
	List<ReplyEntity> findByBoardBno(int bno);
	
	
	//쿼리메서드 :쿼리를 만들어주는 메서드 
//	List<ReplyEntity> findbyBoardBno(int bno);
//
//	
//	@Query("select r from ReplyEntity r where board_bno =#{bno}")
//	List<ReplyEntity> findbyBoardEntityBno(@Param("bno")int bno);
	
}
