package com.cafeatte.magazine.service;

import com.cafeatte.magazine.dao.MagazineDAO;
import com.cafeatte.main.Service;

public class MagazineDeleteService implements Service {
	
	private MagazineDAO dao; 
	
	public MagazineDeleteService(MagazineDAO dao) {
		this.dao = dao; 
	}

	// 데이터 Controller <->service <-> DAO

	@Override
	public Integer service(Object[] objs)throws Exception {
		
		int no = (int)objs[0];
		System.out.println("MagazineDeleteService.service()");
			
		return dao.delete(no);
			
	}
	
}
