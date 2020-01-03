/*
 * 질문하기 처리 
 * - 답변하기 처리 : QnaAnswerService
 */


package com.cafeatte.qna.service;

import com.cafeatte.main.Service;
import com.cafeatte.qna.dao.QnaDAO;
import com.cafeatte.qna.dto.QnaDTO;

public class QnaWriteService implements Service {
	
	private QnaDAO dao;
	
	public QnaWriteService(QnaDAO dao) {
		this.dao = dao;
	}
	@Override
	// 데이터 Controller <-> DAO
	// 입력받은 글(QnaDTO)를 Controller 에서 받아서 처리한다.
	public Integer service(Object[] objs) throws Exception{
// 전달된 데이터의 변환
		QnaDTO dto = (QnaDTO)objs[0];
		// 데이터 처리부분에 해당된다.
		System.out.println("QnaWriteService.service()");
		
		// 질문답변 글쓰기에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// Beans에서 생성된 dao를 생성자를 통해서 전달 받고 호출한다.
			// QnaController - QnaWriteService - [QnaDAO]
			dao.write(dto);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.
//					throw new Exception("질문답변 글쓰기 중 오류가 발생되었습니다.");
			throw e;
		}
	}
	
}
