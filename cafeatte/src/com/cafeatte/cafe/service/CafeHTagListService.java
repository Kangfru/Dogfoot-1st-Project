package com.cafeatte.cafe.service;

import java.util.List;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.hTag.dto.HTagDTO;
import com.cafeatte.main.Service;
import com.cafeatte.util.page.PageObject;

public class CafeHTagListService implements Service {

	private CafeDAO dao;
	public CafeHTagListService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<HTagDTO> service(Object[] objs) throws Exception {
		System.out.println("CafeHTagListService.service()");
		PageObject pageObject = (PageObject) objs[0];
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("CafeHTagListService.service().pageObject : " + pageObject);
		return dao.hTagList(pageObject);
	}

}
