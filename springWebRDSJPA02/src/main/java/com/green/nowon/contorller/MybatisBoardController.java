package com.green.nowon.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.service.MybatisBoardService;
import com.green.nowon.service.MybatisBoardServiceProcess;

@Controller
public class MybatisBoardController {
	
	@Autowired
	private MybatisBoardService service;
	
	@GetMapping("/mybatis/boards")
	public String list(Model model) {
		service.list(model);
		return "board/list";
	}
	
	
	@GetMapping("/mybatis/boards/registration")
	public String write() {
	
		return "board/mybatis-write";
	}
	
	@PostMapping("/mybatis/boards")
	public String save(MyBoardDTO dto) {
		service.save(dto);
		return "redirect:/mybatis/boards";
	}
	
	@GetMapping("/mybatis/boards/{bno}")
	public String detail(@PathVariable long bno , Model model) {
		service.detail(bno ,model);
		
		return "board/detail";
	}
	
	@DeleteMapping("/mybatis/boards/{bno}")
	public String delete(@PathVariable long bno) {
		
		service.delete(bno);
		
		return "redirect:/mybatis/boards";//get요청방식으로
	}
	
	
	
	@PutMapping("/mybatis/boards/{bno}")
	public String update(@PathVariable long bno, MyBoardDTO dto) {
		//수정할 대상  pk , 수정할 DATA
		service.update(bno, dto);
		
		return "redirect:/mybatis/boards/"+bno;//get요청방식으로
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
