package com.cafeatte.qna.service;

import com.cafeatte.main.Service;
import com.cafeatte.qna.dao.QnaDAO;

public class QnaDeleteService implements Service {
	
	private QnaDAO dao;
	
	public QnaDeleteService(QnaDAO dao) {
		this.dao = dao;
	}

	@Override
	public Integer service(Object[] objs) throws Exception {

		int no = (int) objs[0];
		System.out.println("QnaDeleteService.service()");
		
		return dao.delete(no);
	}
	
}
