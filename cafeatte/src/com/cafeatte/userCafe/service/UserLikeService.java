package com.cafeatte.userCafe.service;

import com.cafeatte.main.Service;
import com.cafeatte.userCafe.dao.UserCafeDAO;
import com.cafeatte.userCafe.dto.UserCafeDTO;
import com.cafeatte.userLike.dto.UserLikeDTO;

//데이터실행->dao보냄
public class UserLikeService implements Service {

	private UserCafeDAO dao;

	public UserLikeService(UserCafeDAO dao) {
		this.dao = dao;
	}

	//
	@Override
	public Object service(Object[] objs) throws Exception {
		System.out.println("UserLikeService.service()");
		int no = (int) objs[0];
		System.out.println("no : "+no);
		String id = (String) objs[1];
		System.out.println("id : "+id);
		int vr = (int) objs[2];
		System.out.println("vr : "+vr);
		
		int check = dao.userLikeList(no, id); //로그인한사람이 기존에 좋아요를 한적이있으면 1 없으면 0
		System.out.println("check : "+check);
		
		if (vr == 1) {// 지금 좋아요버튼 클릭하면 {
			if (check == 1) { //좋아요된 기록이 있으면.
				// 좋아요를 한 상태이면 (id,no데이터가 있음)
				dao.userLikeDelete(no, id); // id,no데이터삭제
				dao.decreaseLike(no, id);// 좋아요1감소
			} else { //check==0일때 (좋아요된 기록없을때)
				// 좋아요안된상태이면(id,no데이터없음)
				dao.userLikeInsert(no, id);// 데이터추가
				dao.increaseLike(no, id);// 좋아요1증가
				
			}
		}
		
		return check;
	}
}
