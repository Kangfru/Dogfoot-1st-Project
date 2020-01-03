package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberSignOutService implements Service {

private MemberDAO dao;
	
	public MemberSignOutService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		dao.signOut((String) objs[0]);
		return null;
	}

}
