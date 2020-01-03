package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.cafe.dto.CafeDTO;
import com.cafeatte.main.Service;

public class CafeWriteService implements Service {
	private CafeDAO dao;
	public CafeWriteService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Integer service(Object[] objs) throws Exception {
		System.out.println("CafeWriteService.service()");
		CafeDTO dto = (CafeDTO) objs[0];
		dao.write(dto);
		String tags = (String) objs[1];
		int no = dao.getWriteNo();
		return dao.HTagWrite(no, tags);
	}

}
