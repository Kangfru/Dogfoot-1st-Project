package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberIdCheckService implements Service {

	private MemberDAO dao;
	
	public MemberIdCheckService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("memberIdCheckSerbvice + objs[0] : " + objs[0]);
		return dao.idCheck((String) objs[0]);
	}

}
