package com.green.nowon.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.BoardListDTO;
import com.green.nowon.domain.entity.BoardEntity;
import com.green.nowon.domain.entity.BoardEntityRepository;

@Service
public class BoardServiceProcess implements BoardService {

	// controller는 서비스가 필요하고 데이터베이스에서 데이터를 가져올때는 dao 즉
	// controller->serivce->dao(jpa에서는 repository가대체)
	@Autowired
	private BoardEntityRepository repository;

	@Override
	public void listAll(Model model) {
		// 데이터를 뿌릴려면 entity에 getter가 있어야한다.
		// entity에서 가져오면 불안정하다 그래서 dto를 통해서 가져오
		List<BoardEntity> result = repository.findAll();
		List<BoardListDTO> list = new Vector<>();

		for (BoardEntity e : result) {

			int bno = e.getBno();
			String tittle = e.getTittle();
			int readCount = e.getReadCount();
			String writer = e.getWriter();
			LocalDateTime createdDate = e.getCreatedDate();
			LocalDateTime updatedDate = e.getUpdatedDate();

			BoardListDTO dto = new BoardListDTO();
			dto.setBno(bno);
			dto.setTittle(tittle);
			dto.setReadCount(readCount);
			dto.setWriter(writer);
			dto.setUpdatedDate(updatedDate);

			list.add(dto);

		}

		model.addAttribute("list", list);
	}

	@Override
	public void getlistAll(Model model) {

		//List<BoardEntity> result = repository.findAll();
		//Stream<BoardEntity> st = result.stream();// stream메서드를 통해서 list가 ->
		/*
		 * Function<BoardEntity, BoardListDTO> mapper = new Function<>() { // interface
		 * 아너리너스?로 객체생성?
		 * 
		 * @Override public BoardListDTO apply(BoardEntity t) { // TODO Auto-generated
		 * method stub return null; } };
		 */ //인터페이스내부에 추상메서드가 딱 1개만있으면(@FunctionalInterface) 생략표현이 가능하다. 0-> 람다표현식 이라고부른다.

		// 매핑 기술을 가지고있다 .
		
		//람다식 표현 위에코드랑 동일 
		//{}바디에있는 내용이 1줄이면 {}생략가능 
		//그 1줄이 return문장이면 return 키워드까지 생략 
		//파라미터 갯수가 1개이면 (e) -> e로 생략가능
		//Function<BoardEntity, BoardListDTO> mapper=(e)->{return new BoardListDTO(e);};
//		Function<BoardEntity, BoardListDTO> mapper= e->new BoardListDTO(e);
		
		//생성자 생략   생성자를 파라미터를 던져준다. 생성자를 매핑해서 BoardListDTO로 가져온다
//		Function<BoardEntity, BoardListDTO> mapper= BoardListDTO::new;
//		Stream<BoardListDTO> mappedStream=st.map(mapper); 
//		List<BoardListDTO> finalList=mappedStream.toList();
		
		//stream이 map에 하나씩 뽑아서준다. 
		//model.addAttribute("list" ,repository.findAll().stream().map(BoardListDTO::new).toList());
		model.addAttribute("list" ,repository.MyFindAll().stream().map(BoardListDTO::new).toList());
//		List<BoardListDTO> aaa= new Vector<>();
//		for(BoardEntity e :repository.findAll()) {
//			BoardListDTO dto = new BoardListDTO(e);
//			
//			aaa.add(dto);
//		}

	}

}
