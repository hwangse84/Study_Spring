package kr.co.smart.customer;

import java.util.List;

public interface CustomerService {

	//CRUD
		//고객정보 신규저장
		int customer_register(CustomerVO vo);
		
		//고객목록 조회
		List<CustomerVO> customer_list();
		//
		List<CustomerVO> customer_list(String name);
		//고객정보 조회
	    CustomerVO customer_info(int id);
		//고객정보 변경저장
	    int customer_update(CustomerVO vo);
		//고객정보 삭제
	    int customer_delete(int id);
	}

