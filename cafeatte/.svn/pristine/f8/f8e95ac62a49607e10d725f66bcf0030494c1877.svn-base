package com.cafeatte.main;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cafeatte.main.Controller;


public class ErrorController implements Controller {

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response,
			String uri)
			throws Exception {
		// TODO Auto-generated method stub

		// 공통으로 사용되는 변수
		String jsp = "";
		
		// jsp에서 자바 부분을 여기에 넣는다.
		switch (uri) {
		//권한 없음 uri 처리
		case "/error/nonAuth.do":
			jsp ="error/nonAuth";
			break;
			
		}
		
		System.out.println("ErrorController.execute().jsp:"+jsp);
		
		return jsp;
	}

}
