package com.cafeatte.userCafe.service;

import com.cafeatte.main.Service;
import com.cafeatte.userCafe.dao.UserCafeDAO;
import com.cafeatte.userCafe.dto.UserCafeDTO;

//데이터실행->dao보냄
public class UserCafeWriteService implements Service{
	
	private final UserCafeDAO dao;
	public UserCafeWriteService(UserCafeDAO dao) {
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		UserCafeDTO dto = (UserCafeDTO) objs[0];
		System.out.println("UserCafeWriteService.service()");
			return dao.write(dto);
	}

}
