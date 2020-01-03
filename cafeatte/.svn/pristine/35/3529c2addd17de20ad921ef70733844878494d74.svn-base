package com.cafeatte.magazine.service;

import com.cafeatte.magazine.dao.MagazineDAO;
import com.cafeatte.magazine.dto.MagazineDTO;
import com.cafeatte.main.Service;

public class MagazineViewService implements Service{

	private MagazineDAO dao;
	
	// 사용해야할 dao 객체를 초기화 -> 밖에 생성할 때 넣어준다. 
	public MagazineViewService(MagazineDAO dao) {
		this.dao = dao;
	}

	@Override
		// 데이터 처리부분에 해당된다.
	public MagazineDTO service(Object[] objs) throws Exception {
	
		// 데이터 변환
		int no = (int)objs[0];
		int cnt = (int)objs[1];
		// 데이터 처리부분 
		System.out.println("MagazineViewService.service()");
		
		// MagazineController - MagazineViewService - [MagazineDAO]
		if(cnt == 1) 
			dao.increaseHit(no);// 1증가 시키는 처리문.
		
		return dao.view(no);
	}
	
}
