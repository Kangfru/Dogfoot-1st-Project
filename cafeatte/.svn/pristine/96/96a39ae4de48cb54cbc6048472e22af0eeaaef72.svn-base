package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberChangeStateService implements Service {
	
	private MemberDAO dao;
	
	public MemberChangeStateService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		dao.changeState((String) objs[0], (int) objs[1]); 
		return null;
	}

}
