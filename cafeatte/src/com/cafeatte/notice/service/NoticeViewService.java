package com.cafeatte.notice.service;

import com.cafeatte.main.Service;
import com.cafeatte.notice.dao.NoticeDAO;
import com.cafeatte.notice.dto.NoticeDTO;

public class NoticeViewService implements Service {

	private NoticeDAO dao;
	public NoticeViewService(NoticeDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public NoticeDTO service(Object[] objs) throws Exception{
		int no = (int)objs[0];
		
		System.out.println("NoticeViewService.service()");
		
		return dao.view(no);
	}
	
}
