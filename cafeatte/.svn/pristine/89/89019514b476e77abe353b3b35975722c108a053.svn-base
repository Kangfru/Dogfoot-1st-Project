package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;
import com.cafeatte.member.dto.MemberDTO;

public class MemberUpdateService implements Service {

	private MemberDAO dao;
	
	public MemberUpdateService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		return dao.update((MemberDTO) objs[0]);
	}

}
