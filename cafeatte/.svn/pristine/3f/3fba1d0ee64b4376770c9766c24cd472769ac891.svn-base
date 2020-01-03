package com.cafeatte.userCafe.service;

import com.cafeatte.main.Service;
import com.cafeatte.userCafe.dao.UserCafeDAO;
import com.cafeatte.userCafe.dto.UserCafeDTO;

public class UserCafeUpdateService implements Service{

	private final UserCafeDAO dao;
	public UserCafeUpdateService(UserCafeDAO dao) {
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("UserCafeUpdateService.service()");
		UserCafeDTO dto = (UserCafeDTO) objs[0];
		String id = (String) objs[1];
		try {
			return dao.update(dto, id);
		} catch (Exception e) {
			throw e;
		}
	}
}
