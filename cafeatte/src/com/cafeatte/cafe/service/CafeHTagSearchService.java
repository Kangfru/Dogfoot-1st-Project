package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.main.Service;
import com.cafeatte.util.page.PageObject;

public class CafeHTagSearchService implements Service {

	private CafeDAO dao;
	public CafeHTagSearchService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public String service(Object[] objs) throws Exception {
		System.out.println("CafeHTagSearchService.service()");
		PageObject pageObject = (PageObject) objs[0];
		return dao.hTagSearchList(pageObject);
	}

}
