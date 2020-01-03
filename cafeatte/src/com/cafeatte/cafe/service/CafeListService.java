package com.cafeatte.cafe.service;

import java.util.List;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.cafe.dto.CafeDTO;
import com.cafeatte.main.Service;
import com.cafeatte.util.page.PageObject;

public class CafeListService implements Service {

	private CafeDAO dao;
	public CafeListService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<CafeDTO> service(Object[] objs) throws Exception {
		System.out.println("CafeListService.service()");
		PageObject pageObject = (PageObject) objs[0];
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("CafeListService.service().pageObject : " + pageObject);
		return dao.list(pageObject);
	}

}
