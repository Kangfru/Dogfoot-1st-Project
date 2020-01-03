package com.cafeatte.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception; 
	
}
