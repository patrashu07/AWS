package com.green.nowon;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.green.nowon.domain.entity.JpaMember;
import com.green.nowon.domain.entity.JpaMemberRepository;

import oracle.net.aso.j;

@SpringBootTest
class SpringWebRdsjpaApplicationTests {
	//DAO 역할을 JpaMemberRepository 가한다.
	
	@Autowired
	JpaMemberRepository repository;
	
	@Test
	void 조회() {
		List<JpaMember> result = repository.findAll();
		for(JpaMember entity : result) {
			System.out.println(entity);
		}
	
	}
	@Test
	void 삭제() {
		Optional<JpaMember> result =repository.findById(1L);
		if(result.isPresent()) {
			repository.deleteById(1L);
		}
	}
	
	@Test
	void 수정_다른유형() {
		repository.save(repository.findById(1L).get().updateNickName("수정?"));
		//JpaMember result=repository.findById(1L).orElseThrow();
			//orElseThrow() 예외처리 
	}
	
	@Commit
	@Transactional // 한번만 접속해서 명령어 다 수행시키고 그때 close 할게요 자동롤백 `1
	@Test
	void 수정_다른유형2() {
		repository.findById(1L).get().updateNickName("수정이될까요");
	}
	
	
	
	
	
	
	
	//@Test 
	void 수정() {
		//존재유무확인
		Optional<JpaMember> result=repository.findById(1L); //null이발생하면 오류가 생기기때문에 해결하기위해서  Optional을 사용 
		if(result.isEmpty()) { 
			
			System.out.println("존재하지않은 데이터입니다.");
			return;
		
		}
		//존재하네요
		JpaMember entity=result.get();//현재존재하는 원본 
		String nickName = "노원01";
		entity.updateNickName(nickName);
		repository.save(entity);
	}
	
	@Test
	void contextLoads() {
	}
	
//	@Test
//	void 데이터삽입테스트_생성() {
//		JpaMember entity = JpaMember.builder()
//				.eamil("emailtest")
//				.password("1234")
//				.build();
//		repository.save(entity);
//		
//	}
}
