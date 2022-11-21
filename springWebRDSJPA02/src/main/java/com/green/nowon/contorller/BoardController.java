package com.green.nowon.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private  BoardService service;
	
	@GetMapping("/boards") // model 객체도 request로 인해 가져다준다? 
	public String list(Model model) {
		//service.listAll(model);
		service.getlistAll(model);
		return "board/list";//model객체는 응답페이지까지 전달해준다.
		
	}
}
