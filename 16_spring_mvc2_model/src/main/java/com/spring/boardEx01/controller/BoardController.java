package com.spring.boardEx01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boardEx01.dto.BoardDTO;
import com.spring.boardEx01.service.BoardService;

// 이제 url로 바로 웹페이지에 접근할 수 없고 컨트롤러가 길을 알려준다. 

@Controller							// 컨트롤러임을 명시(controller bean에 등록시킴)
public class BoardController {
	
	@Autowired						// DI (의존성주입)
	private BoardService boardService;

	// value에는 url 주소를 명시, method는 요청타입을 명시 (이 url에 get으로 접근시 리턴값의 jsp 파일로 보내줌)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {			// 별로 메소드명은 중요하지 않음
		return "boardEx01/main";	// servlet-context에 명시된 대로(prefix와 suffix) 포워딩 시킬 jsp파일을 작성해준다.
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(Model model) throws Exception {
		
		List<BoardDTO> boardList = boardService.listAll(); 
		model.addAttribute("boardList", boardList);		// model.addAttribute("boardList", boardService.listAll());
		
		return "boardEx01/bList";
	}
	
	@RequestMapping(value="/boardWrite", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "boardEx01/bWrite";
	}
	
	@RequestMapping(value="/boardWrite", method = RequestMethod.POST)
	public String boardWriteAction(BoardDTO bdto) throws Exception {
		
		boardService.insert(bdto);
		return "redirect:boardList";		// redirect:해당 페이지로 이동한다. 
	}
	
	@RequestMapping(value="/boardInfo")
	public String boardInfo(@RequestParam("num") int num, Model model) throws Exception {
		BoardDTO bdto = boardService.read(num);
		model.addAttribute("bdto", bdto);
		return "boardEx01/bInfo";
	}
	
	// 수정하기 버튼을 누르면, get으로 num 만 받은경우. 받아온 값을 조회해서 뿌린다. 
	@RequestMapping(value="/boardUpdate", method = RequestMethod.GET)
	public String boardUpdateForm(@RequestParam("num") int num, Model model) throws Exception {
		BoardDTO bdto = boardService.read(num);
		model.addAttribute("bdto", bdto);
		return "boardEx01/bUpdate";
	}
	
	// 다른 부분. 글수정 버튼을 누르면, post로 form의 내용을 받아온다.
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardDTO bdto, Model model) throws Exception {
		if(boardService.modify(bdto))	model.addAttribute("success", true);
		else							model.addAttribute("success", false);
		
		return "boardEx01/bUpdatePro";
	}
	
}
