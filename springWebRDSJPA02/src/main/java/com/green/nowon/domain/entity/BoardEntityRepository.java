package com.green.nowon.domain.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//기선아 인터페이스로 만드는거 까먹지말자 
//BoardEntity에접근하는 DAO역할
@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity,Integer> {

	
	@Query("select b from BoardEntity b")
	List<BoardEntity> MyFindAll();
	
}