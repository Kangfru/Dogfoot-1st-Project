package com.cafeatte.util.io;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {

	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SURFIX = ".jsp";

	// jsp 파일의 위치와 파일명을 만들어내는 메서드
	public static String getJsp(String str) {
		return PREFIX + str + SURFIX;
	}

	// jsp파일로 셋팅하면 jsp쪽으로 forward시키고 redirect를 하려면 url("redirect:"+url)을 셋팅해서 사용.
	public static void forward(HttpServletRequest request, HttpServletResponse response, String jsp)
			throws IOException, ServletException {
		if (jsp.indexOf("redirect:") == 0) {
			// jsp로 넘어오는 데이터가 url인 경우 처리
			// 앞에 붙어있는 redirect: 제거
			jsp = jsp.substring("redirect:".length());
			response.sendRedirect(jsp);
			return;
		} else {
			System.out.println(jsp);
			// jsp쪽으로 이동하기 위해 forward한다.
			request.getRequestDispatcher(getJsp(jsp)).forward(request, response);
			return;
		}
	}

}
