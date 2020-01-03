package com.cafeatte.notice.service;

import com.cafeatte.main.Service;
import com.cafeatte.notice.dao.NoticeDAO;
import com.cafeatte.notice.dto.NoticeDTO;

public class NoticeWriteService implements Service{

	private NoticeDAO dao;
	
	public NoticeWriteService(NoticeDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception{
		System.out.println("NoticeWriteService.service()");
		
		NoticeDTO dto = (NoticeDTO) objs[0];
		
		try {
			return dao.write(dto);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
}
