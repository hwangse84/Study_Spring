package kr.co.smart;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.smart.member.MemberService;
import kr.co.smart.member.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//org.apache.commons.dbcp2.BasicDataSource" 
	@Autowired private MemberService member;
	@Autowired private BCryptPasswordEncoder pwEncoder;
	
	//오류발생시 화면연결
	@RequestMapping("/error")
	public String error(HttpServletRequest request,Model model) {
		
		//오류내용을 화면에 출력할 수 있도록  Model에 담기
		int code = (Integer)request.getAttribute("javax.servlet.error.status_code");
		if(code==500) {
			Throwable exception = (Throwable)request.getAttribute("javax.servlet.error.exception");
			model.addAttribute("error",exception.toString());
		}
		
		return "default/error/" + (code == 404? 404 : "common");
	}
	
	
	
	//org.apache.commons.dbcp2.BasicDataSource-config에서 사용
	//org.mybatis.spring.SqlSessionFactoryBean
	//org.mybatis.spring.SqlSessionTemplate
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	//시각화 화면 요청
			@RequestMapping("/visual/list")
			public String list(HttpSession session){
				session.setAttribute("category", "vi");
				
				return "visual/list";
			}
			
			
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
	
	//public String home(Locale locale, Model model) {
		//테스트하는 동안 사용할 수 있도록 임시 로그인처리 ----------------------
		//String user_id = "gkgkgk", user_pw = "0000" ;
		//String user_id = "rkrkrk", user_pw = "0000" ;
		String user_id = "hanul202", user_pw = "0000" ;
		//String user_id = "admin", user_pw = "Admin11" ;
		MemberVO vo = member.member_info(user_id);
		if( pwEncoder.matches(user_pw, vo.getUser_pw()) ) {
			session.setAttribute("loginInfo", vo);//로그인 되어있게 처리함
		}
		//---------------------------------------------------------
		
		
		session.removeAttribute("category");
		//session.setAttribute("category", "");
		return "home";
	}
	
}
