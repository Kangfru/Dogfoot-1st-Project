package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.main.Service;

public class CafeHTagViewService implements Service {

	private CafeDAO dao;
	public CafeHTagViewService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public String service(Object[] objs) throws Exception {
		System.out.println("CafeHTagViewService.service()");
		int no = (int) objs[0];
		return dao.HTagView(no);
	}

}
