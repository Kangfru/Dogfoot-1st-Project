package com.cafeatte.qna.service;

import com.cafeatte.main.Service;
import com.cafeatte.qna.dao.QnaDAO;
import com.cafeatte.qna.dto.QnaDTO;

public class QnaViewService implements Service {

	private QnaDAO dao;
	public QnaViewService(QnaDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}

	@Override
	// 데이터 Controller <->DAO
	// 글번호를 Controller 에서 받아서 처리한다.
	public QnaDTO service(Object[] objs)throws Exception {
		//데이터 변환
		int no = (int)objs[0];
		int inc = (int)objs[1];
		// 데이터 처리 부분에 해당 된다. 
		System.out.println("QnaViewService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 가져와서 호출한다.
		// QnaContrlloer - QnaListService - [QnaDAO]
		// inc값이 1인 경우 조회수 1증가 시키는 처리 
		if (inc == 1)
			dao.increaseHit(no);// 1증가 시키는 처리문.
		return dao.view(no);
	}
	
}
