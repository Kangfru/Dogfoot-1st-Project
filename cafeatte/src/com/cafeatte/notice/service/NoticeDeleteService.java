package com.cafeatte.notice.service;

import com.cafeatte.notice.dao.NoticeDAO;
import com.cafeatte.main.Service;

public class NoticeDeleteService implements Service{


	private NoticeDAO dao;
	public NoticeDeleteService(NoticeDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Integer service(Object[] objs) throws Exception{
		int no = (int)objs[0];
		
		System.out.println("NoticeDeleteService.service()");
		
		try {
			return dao.delete(no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	
}
