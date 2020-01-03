package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;
import com.cafeatte.member.dto.MemberDTO;

public class MemberJoinService implements Service {

private MemberDAO dao;
	
	public MemberJoinService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO dto = (MemberDTO) objs[0];
		dao.join(dto);
		
		return null;
	}

}
