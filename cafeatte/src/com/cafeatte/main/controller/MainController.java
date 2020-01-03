package com.cafeatte.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.util.page.PageObject;

public class MainController implements Controller {

	private Service cafeHTagListService;
	private Service cafeListService;
	private Service magazineMListService;
	private Service userCafeListService;
	// 생성자를 이용한 DI 적용
	public MainController(Service cafeHTagListSerivce, Service cafeListService, Service magazineMListService, Service userCafeListService) {
		this.cafeHTagListService = cafeHTagListSerivce;
		this.cafeListService = cafeListService;
		this.magazineMListService = magazineMListService;
		this.userCafeListService = userCafeListService;
	
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, String uri) throws Exception {
	
		PageObject pageObject = new PageObject(1, 5);
		request.setAttribute("hTags", Execute.service(cafeHTagListService, pageObject));
		request.setAttribute("cafeList", Execute.service(cafeListService, pageObject));				
		
		pageObject = new PageObject(1,5);
		request.setAttribute("mlist", Execute.service(magazineMListService, pageObject));
		
		pageObject = new PageObject(1,7);
		request.setAttribute("userCafeList", Execute.service(userCafeListService, pageObject));
		
		return "main/main";
	}

}
