package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;
import com.cafeatte.util.page.PageObject;

public class MemberListService implements Service {

	private MemberDAO dao;
	
	public MemberListService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		PageObject pageObject = (PageObject) objs[0];
		System.out.println("MemberListService.List.service()");
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("MemberListService.service().pageObject : " + pageObject);
		
		return dao.list(pageObject);
	}

}
