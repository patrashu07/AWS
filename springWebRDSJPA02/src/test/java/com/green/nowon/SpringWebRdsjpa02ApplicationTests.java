package com.green.nowon;

import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.nowon.domain.dao.MyBoardMapper;
import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.domain.entity.BoardEntity;
import com.green.nowon.domain.entity.BoardEntityRepository;
import com.green.nowon.domain.entity.ReplyEntity;
import com.green.nowon.domain.entity.ReplyEntityRepository;

@SpringBootTest
class SpringWebRdsjpa02ApplicationTests {

	@Autowired
	BoardEntityRepository repository;
	@Autowired
	ReplyEntityRepository newrepository;
	
	@Autowired
	MyBoardMapper myBoardMapper;
	
	@Test
	void insert() {
		MyBoardDTO obj=MyBoardDTO.builder().title("제목테스트").content("내용").writer("zeous").build();
		
		myBoardMapper.save(obj);
	}
	
	
	
	
	
	
	
	//@Test
		void 더미() {
			
		 IntStream.rangeClosed(1,100).forEach(i->{
			 repository.save(BoardEntity.builder()
						.tittle("제목"+i)
						.content("내용"+i)
						.build()); 
		 });
			
		}
	
	
	//@Test
	void 댓글reply삽입() {
		//ReplyEntity e1=new ReplyEntity(0, null, null, null, null);
		ReplyEntity e2=ReplyEntity.builder()
				.text("댓글1")
				.writer("안재성")
				.board(BoardEntity.builder().bno(1).build())
				.build();
		newrepository.save(e2);
		
	}
	
	
	//@Test
	void contextLoads() {
		
		repository.save(BoardEntity.builder()
				.tittle("제목32")
				.content("내용32")
				.build());
	}

	//@Test
	void 삭제() {
		repository.deleteById(1);
	}
	
	//@Test  //error 소문자 로인한 오류
	void 게시글_상세펯이지() {
		int bno =1;              //존재하지않으면 no search해주ㅠ세요
		BoardEntity result = repository.findById(bno).orElseThrow();
		System.out.println(result);
		
		List<ReplyEntity> replyResult = newrepository.findByBoardBno(bno);
		
	}
	
		@Transactional
		@Test
		void 게시글_상세펯이지2() {
			int bno =1;              //존재하지않으면 no search해주ㅠ세요
			BoardEntity result = repository.findById(bno).orElseThrow();
			System.out.println(result);
			
			result.getReplies().forEach(System.out::println);
			
		}
	
	
}
