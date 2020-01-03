package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberChangePwService implements Service {

	private MemberDAO dao;
	
	public MemberChangePwService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberChangePwService.service() id : " + objs[0] + " pw : " + objs[1]);
		return dao.changePw((String) objs[0],(String) objs[1]) ;
	}

}
