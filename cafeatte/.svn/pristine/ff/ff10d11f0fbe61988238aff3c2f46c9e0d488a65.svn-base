package com.cafeatte.notice.service;

import com.cafeatte.notice.dao.NoticeDAO;
import com.cafeatte.notice.dto.NoticeDTO;
import com.cafeatte.main.Service;

public class NoticeUpdateService implements Service{

	private NoticeDAO dao;
	public NoticeUpdateService(NoticeDAO dao) {
		this.dao = dao;
	}

	@Override
	public Integer service(Object[] objs) throws Exception{
		NoticeDTO dto = (NoticeDTO)objs[0];
		
		System.out.println("NoticeUpdateService.service()");
		
		try {
			return dao.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
}
