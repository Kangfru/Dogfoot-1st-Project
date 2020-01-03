package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberFindPwService implements Service {

private MemberDAO dao;
	
	public MemberFindPwService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		return dao.findPw((String) objs[0], (String) objs[1]);
	}

}
