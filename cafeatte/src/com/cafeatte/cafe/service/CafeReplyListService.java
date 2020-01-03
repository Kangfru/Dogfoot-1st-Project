package com.cafeatte.cafe.service;

import java.util.List;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.main.Service;
import com.cafeatte.reply.dto.ReplyDTO;

public class CafeReplyListService implements Service {
	private CafeDAO dao;
	public CafeReplyListService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public List<ReplyDTO> service(Object[] objs) throws Exception {
		System.out.println("CafeReplyListService.service()");
		int no = (int) objs[0];
		return dao.replyList(no);
	}

}
