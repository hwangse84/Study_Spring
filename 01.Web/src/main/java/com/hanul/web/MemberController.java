package com.hanul.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.MemberVO;

@Controller
public class MemberController {

	@RequestMapping("/login_result")
	public String login(String userid, String userpw){
		//아이디/비번 일치해서 로그인 성공하면 home으로 화면 연결
		//          일치하지 않아서 로그인 실패하면 로그인화면으로 연결!
		//아이디 : hong ,비번: 0000이면 로그인 성공
		if(userid.equals("hong") && userpw.equals("0000")) {
			//return "home";//forward방식
			return "redirect:/";   //redirect 방식을 사용해야한다.
			
		}else {
			//return "member/login";//forward방식
			return "redirect:login";   //redirect 방식을 사용해야한다.
		}
		
	}
			

	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
			
	
	@RequestMapping("joinPath/{name}/{gender}/{e}/{age}")
	
	public String join(Model model,@PathVariable String name,@PathVariable String gender,
			@PathVariable("e") String mail, @PathVariable int age) {
		model.addAttribute("name",name);
		model.addAttribute("email",mail);
		model.addAttribute("gender",gender);
		model.addAttribute("age",age);
		model.addAttribute("method","@PathVariable방식");
		return "member/info";
	}
	
	//Controller-.Parameter 접근해 DTO에 담아야한다
	//DTO dao=new DTO();
	//dto.setName(name)
	//..
	//DB에 저장처리 메소드 호출할때 파라미터로 객체의 주소만 보낸다
	@RequestMapping("/joinData")
	public String join(Model model,MemberVO vo){
		model.addAttribute("vo",vo);
		model.addAttribute("method", "데이터객체 방식");
		return "member/info";
	}
	
	
	//화면을 통해 서블릿된 파라미터를 joinParam로 접근하기
	@RequestMapping("/joinParam")
	public String join(Model model,int age,@RequestParam("email") String mail,String gender,@RequestParam String name) {
		
		model.addAttribute("age", age);
		model.addAttribute("email", mail);
		model.addAttribute("gender", gender);
		model.addAttribute("name", name);
		model.addAttribute("method", "@RequestParam방식");
		return "member/info";
	}
	@RequestMapping("/joinRequest")
	public String join(HttpServletRequest request,Model model) {
		//화면을 통해 서블릿된 파라미터를 HttpServletRequest로 접근하기
		String name=request.getParameter("name");
		model.addAttribute("name", name);
		model.addAttribute("gender", request.getParameter("gender"));
		model.addAttribute("email", request.getParameter("email"));
		
		//String->int->Integer.ParsInt:int
		//String->int->Integer.valueOf:integer
		//Integer no1=new Integer(10);
		//int no2=no1;//Integer->int:Auto Unboxing
		
		model.addAttribute("age",Integer.valueOf(request.getParameter("age")));
		model.addAttribute("method", "HttpServletRequest 방식");
		
		return "member/info";
		
	}
	@RequestMapping("/member")
	public String member() {
		
		return "member/join";
	}
}
