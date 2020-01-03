package com.cafeatte.coupon.service;

import com.cafeatte.coupon.dao.CouponDAO;
import com.cafeatte.coupon.dto.CouponDTO;
import com.cafeatte.main.Service;

public class CouponUpdateService implements Service {

	private CouponDAO dao;
	
	public CouponUpdateService(CouponDAO dao) {
		this.dao = dao;
	}
	
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		dao.update((CouponDTO) objs[0]);
		return null;
	}

}
