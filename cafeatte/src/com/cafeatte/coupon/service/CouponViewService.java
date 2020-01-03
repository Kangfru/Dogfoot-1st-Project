package com.cafeatte.coupon.service;

import com.cafeatte.coupon.dao.CouponDAO;
import com.cafeatte.main.Service;

public class CouponViewService implements Service {

private CouponDAO dao;
	
	public CouponViewService(CouponDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		return dao.view((int) objs[0]);
	}

}
