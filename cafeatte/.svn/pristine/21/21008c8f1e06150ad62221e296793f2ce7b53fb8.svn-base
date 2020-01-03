package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.main.Service;
import com.cafeatte.reply.dto.ReplyDTO;

public class CafeReplyWriteService implements Service {
	private CafeDAO dao;
	public CafeReplyWriteService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Integer service(Object[] objs) throws Exception {
		System.out.println("CafeReplyWriteService.service()");
		return dao.replyWrite((ReplyDTO) objs[0]);
	}

}
