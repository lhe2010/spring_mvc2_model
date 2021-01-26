package com.spring.boardEx01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 이제 url로 바로 웹페이지에 접근할 수 없고 컨트롤러가 길을 알려준다. 

@Controller							// 컨트롤러임을 명시(controller bean에 등록시킴)
public class BoardController {

	// value에는 url 주소를 명시, method는 요청타입을 명시 (이 url에 get으로 접근시 리턴값의 jsp 파일로 보내줌)
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {			// 별로 메소드명은 중요하지 않음
		return "boardEx01/01_main";	// servlet-context에 명시된 대로(prefix와 suffix) 포워딩 시킬 jsp파일을 작성해준다.
	}
}
