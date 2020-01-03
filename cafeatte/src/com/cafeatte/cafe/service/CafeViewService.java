package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.cafe.dto.CafeDTO;
import com.cafeatte.main.Service;

public class CafeViewService implements Service {

	private CafeDAO dao;
	public CafeViewService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public CafeDTO service(Object[] objs) throws Exception {
		System.out.println("CafeViewService.service()");
		int no = (int) objs[0];
		int cnt = (int) objs[1];
		if(cnt == 1) {
			dao.increaseHit(no);
		}//if end
		return dao.view(no);
	}

}
