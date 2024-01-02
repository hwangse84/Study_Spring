package kr.co.middle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kr.co.middle.customer.CustomerService;
import kr.co.middle.customer.CustomerVO;

@RestController//@Controller +@ResponseBody
@RequestMapping(value="/customer",produces="text/plain;charset=utf-8")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/insert")
	public void insert(String vo) {
		CustomerVO customer=new Gson().fromJson(vo, CustomerVO.class);
		service.customer_insert(customer);
	}
	
	@RequestMapping("/update")
	public void update(String vo) {
		//vo:{"customer_id":83,"name":"하지원","phone":"63935","email":"aa@asd","gender":"여"}
		CustomerVO customer=new Gson().fromJson(vo, CustomerVO.class);
		service.customer_update(customer);
	}
	
	//고객목록조회 요청
	
	@RequestMapping("/list")
	public String list(String query) {
		List<CustomerVO> list=service.customer_list(query);

		return new Gson().toJson(list);
	}
	//-customer/info요청시
	//:파라미터
	
	@RequestMapping("/info")
	public String info(int id) {
		
		return new Gson().toJson(service.customer_info(id));
	}
	
	@RequestMapping("/delete")
	public void delete(int id) {
		service.customer_delete(id);
	}
	
	
	
	//각 요청에 대한 처리시 조회해온 데이터를 Gson객체를 사용해 json형태의 문자열을 만든다
	//json문자열을 PrinWriter의 print메소드를 사용해 출력을 내보내지 않고 
	//System.out.print로 출력해본다.

}
