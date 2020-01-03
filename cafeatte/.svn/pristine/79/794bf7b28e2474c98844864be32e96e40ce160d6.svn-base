package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberCheckNewPwService implements Service {

	private MemberDAO dao;
	
	public MemberCheckNewPwService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkNewPw((String) objs[0], (String) objs[1]);
	}

}
