package com.green.nowon.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.green.nowon.domain.dto.mybatis.MyReply;

@Mapper
public interface MyReplyMapper {

	@Insert("insert into my_reply(text, writer, bno) values(#{text}, #{writer}, #{bno})")
	void save(MyReply dto);

	@Select("select * from my_reply where bno=#{fk} order by rno desc")
	List<MyReply> findAllByBno(@Param("fk") long bno);

	@Delete("delete from my_reply where rno=#{rno}")
	int deleteByRno(long rno);

	@Update("update my_reply set text=#{text} where rno=#{rno}")
	void update(@Param("rno")long rno,@Param("text") String text);

	//최대 5개만
	@Select("select * from my_reply where bno=#{fk} order by rno desc limit #{offset}, #{size}")
	List<MyReply> findByBno(@Param("fk") long bno,@Param("offset") int offset,@Param("size") int size);
	
	@Select("select * from my_reply where bno=#{fk} order by rno desc")
	List<MyReply> findByBnoAndRowBounds(@Param("fk") long bno, RowBounds rowBounds);

	@Select("select count(*) from my_reply where bno=#{bno}")
	int countAll(long bno);

}