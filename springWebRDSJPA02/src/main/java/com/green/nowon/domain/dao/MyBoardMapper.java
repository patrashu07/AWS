package com.green.nowon.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;

@Mapper
public interface MyBoardMapper {
	  
	
	//주석이유xml로 대체
	
	@Select("select * from my_board")
	List<MyBoardDTO> findAll();

	//@Insert("insert into my_board(title, content, writer, read_count)"
		//	+"values(#{title},#{content},#{writer},#{readCount})")
	void save(MyBoardDTO obj);

	@Select("select * from my_board where bno=#{bno}")
	MyBoardDTO findById(long bno);

	//@Delete("delete from my_board where bno=#{bno}")
	void deleteByBno(long bno);

	//@Update("update my_board set title=#{title},content=#{content} where bno=#{bno}")
	void updateByBno(MyBoardDTO dto);



	
	
}
