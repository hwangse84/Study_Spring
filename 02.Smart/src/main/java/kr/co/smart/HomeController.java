package kr.co.smart;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
	
	//org.apache.commons.dbcp2.BasicDataSource-config에서 사용
	//org.mybatis.spring.SqlSessionFactoryBean
	//org.mybatis.spring.SqlSessionTemplate
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
	
	//public String home(Locale locale, Model model) {
		
		//테스트하는 동안 사용할 수 있도록 임시 로그인 처리
		String user_id="hanul201", user_pw="852931fd-935c-42ff-b36c-de296f5ce703";
		MemberVO vo= member.member_info(user_id);
		if(pwEncoder.matches(user_pw,vo.getUser_pw())) {
			session.setAttribute("loginInfo", vo);
		}
		session.removeAttribute("category");
		//session.removeAttribute(category,"");
	return "home";
		
	}
	
}
