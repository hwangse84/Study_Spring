package kr.co.smart;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.smart.visual.VisualService;


	//시각화
	//	@Controller +  @ResponseBody=@RestController
    @RestController
	 @RequestMapping("/visual")
public class VisualController {
    	
		@Autowired private VisualService service;
		
		
		
		
		//부서원수 조회요청
		@RequestMapping("/department")
		public List<HashMap<String, Object>> department(){
			return service.department();
		
		}
}
