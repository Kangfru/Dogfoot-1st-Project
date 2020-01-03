package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.main.Service;

public class CafeHTagDeleteService implements Service {
	private CafeDAO dao;
	public CafeHTagDeleteService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("CafeHTagDeleteService.service()");
		int no = (int) objs[0];
		return dao.HTagDelete(no);
	}

}
