package com.cafeatte.userCafe.service;

import com.cafeatte.main.Service;
import com.cafeatte.userCafe.dao.UserCafeDAO;
import com.cafeatte.userCafe.dto.UserCafeDTO;
import com.cafeatte.userLike.dto.UserLikeDTO;

//데이터실행->dao보냄
public class UserLikeCntService implements Service {

	private UserCafeDAO dao;

	public UserLikeCntService(UserCafeDAO dao) {
		this.dao = dao;
	}

	//
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("UserLikeCntService.service()");
		int no = (int) objs[0];
	
		return dao.cntLike(no);
	}
}
