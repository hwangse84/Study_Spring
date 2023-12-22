package kr.co.smart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.smart.customer.CustomerServiceImpl;
import kr.co.smart.customer.CustomerVO;

@Controller
public class CustomerController {
	
	@Autowired private CustomerServiceImpl service;
	
	//신규고객정보 요청
   @RequestMapping("/insert.cu")
	public String insert(CustomerVO vo) {
			//화면에서 입력한 정보로 db에 신규저장하기->목록화면으로 연결
			service.customer_register(vo);
			return "redirect:list.cu";
		}
	
	//신규고객정보입력화면 요청
	@RequestMapping("/register.cu")
	public String register() {
		return "customer/register";
	}
	//고객정보삭제처리  요청
	@RequestMapping("/delete.cu")
	public String delete(int id) {
		
		//선택한 고객정보를 DB에서 삭제->목록으로 연결!
		service.customer_delete(id);
		return "redirect:list.cu";
	}
	@RequestMapping("/update.cu")
	//고객정보수정 저장처리  요청
	public String update(CustomerVO vo) {
	//화면에서 변경입력한 정보로 DB에 변경저장한다
		service.customer_update(vo);
		
		//화면연결-고객정보화면응답
		return "recirect :info.cu?id= " + vo.getCustomer_id();
		
	}
	//DML처리를 한 후 화면연결은 반드시 redirect!!!
	
	
	//고객정보수정화면  요청
	@RequestMapping("/modify.cu")
	public String modify(int id,Model model) {
		//화면에서 선택한 고객정보를 DB에서 조회해와 수정화면에 출력해서 Model객체에담기 
		model.addAttribute("vo",service.customer_info(id));
		return "customer/modify";
	}
	
	//고객정보화면  요청
	@RequestMapping("/info.cu")
	public String info(Model model,int id) {
		//화면에서 선택한 고객정보를 DB에서 조회해와 정보화면에 출력
		//조회해돈 정보를 화면에 출력할 수 있도록 Model객체에 담기
		
		CustomerVO vo= service.customer_info(id);
		model.addAttribute("vo", vo);
		return "customer/info";
	}
	
	//고객목록화면 요청
	@RequestMapping("/list.cu")
  public String list(Model model,HttpSession session,@RequestParam(defaultValue="0") String name ) {
		//defaultValue="0":데이터가 있는지 없는지 구분
	//DB에서 고객목록을 조회해와 화면에 출력
		List<CustomerVO> list=  service.customer_list(name);
		//조회만 정보를 화면에 출력할 수 있도록 Model객체에 담기
		model.addAttribute("list",list);
		model.addAttribute("name", name);
	    return "customer/list";
}
	

	public String list(Model model,String name,HttpSession session) {
			//defaultValue="0":데이터가 있는지 없는지 구분
		//DB에서 고객목록을 조회해와 화면에 출력
			List<CustomerVO> list= name==null? service.customer_list(): service.customer_list(name);
			//조회만 정보를 화면에 출력할 수 있도록 Model객체에 담기
			model.addAttribute("list",list);
		    return "customer/list";
	}
	
}
