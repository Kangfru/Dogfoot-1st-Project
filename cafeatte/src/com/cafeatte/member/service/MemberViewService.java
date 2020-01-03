package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberViewService implements Service {

	private MemberDAO dao;
	
	public MemberViewService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		return dao.view((String) objs[0]);
	}

}
