package com.cafeatte.notice.service;


import java.util.List;

import com.cafeatte.main.Service;
import com.cafeatte.notice.dao.NoticeDAO;
import com.cafeatte.notice.dto.NoticeDTO;
import com.cafeatte.util.page.PageObject;

public class NoticeListService implements Service {

	private NoticeDAO dao;
	
	public NoticeListService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<NoticeDTO> service(Object[] objs) throws Exception{
		
		PageObject pageObject = (PageObject)  objs[0];
		
		System.out.println("NoticeListService.service()");
		
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		return dao.list(pageObject);
	}
}
