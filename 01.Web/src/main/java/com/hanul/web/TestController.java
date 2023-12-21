package com.hanul.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	//두번쨰 테스트
	@RequestMapping("/second")
	public ModelAndView second() {
		ModelAndView modal=new ModelAndView();
		String now=new SimpleDateFormat("hh시 mm분 ss초").format(new Date());
		modal.addObject("now",now);
		modal.addObject("type","modelAndView");
		modal.setViewName("index");
		return modal;
		
	}

	//첫번쨰 테스트
	@RequestMapping("/first")
	public String first(Model model) {
		//웹브라우저의first라는 요청이 들어오면
		//응답할 화면을 연결:index.jsp
		//오늘 날짜!2023년 12월20일)를 응답화면에 출력할 수 있도록 Model객체에 attribute에 담는다
		String today=new SimpleDateFormat("yyyy년 mm월 dd일").format(new Date());
		
		model.addAttribute("today","Modal");
		model.addAttribute("today",today);
		return  "index";
	}
}
