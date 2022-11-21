package com.green.nowon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dao.MyBoardMapper;
import com.green.nowon.domain.dao.MyReplyMapper;
import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.domain.dto.mybatis.MyReply;

@Service
public class MybatisBoardServiceProcess implements MybatisBoardService {
	
	//mybatis 을 이용한 db : dao-mapper
	@Autowired
	MyBoardMapper mapper;
	
	@Override
	public void list(Model model) {
	 List<MyBoardDTO> result = mapper.findAll();
	 model.addAttribute("list",result);
	}

	@Override
	public void save(MyBoardDTO dto) {
		mapper.save(dto);
		
	}
 
	@Autowired
	MyReplyMapper myReplyMapper;
	
	@Override
	public void detail(long bno, Model model) {
		MyBoardDTO result = mapper.findById(bno);
		model.addAttribute("detail",result);
		
		
	}

	@Override
	public void delete(long bno) {
		// TODO Auto-generated method stub
		mapper.deleteByBno(bno);
		
	}

	@Override
	public void update(long bno, MyBoardDTO dto) {
		//dto에있는 bno값을 시작전에 미리 세팅후 만들자~
		dto.setBno(bno);
		mapper.updateByBno(dto);
		
		
	}

}
