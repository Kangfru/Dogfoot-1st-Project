package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.main.Service;

public class CafeHTagUpdateService implements Service {
	private CafeDAO dao;
	public CafeHTagUpdateService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Integer service(Object[] objs) throws Exception {
		System.out.println("CafeHTagUpdateService.service()");
		int no = (int) objs[0];
		String tags = (String) objs[1];
		return dao.HTagWrite(no, tags);
	}

}
