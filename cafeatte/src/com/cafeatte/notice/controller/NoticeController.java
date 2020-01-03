package com.cafeatte.notice.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafeatte.main.Controller;
import com.cafeatte.main.Service;
import com.cafeatte.notice.dto.NoticeDTO;
import com.cafeatte.main.Execute;
import com.cafeatte.util.page.PageObject;

public class NoticeController implements Controller {

	private Service listService;
	private Service viewService;
	private Service writeService;
	private Service updateService;
	private Service deleteService;
	
	public NoticeController(Service listService, Service viewService, Service writeService,
			Service updateService, Service deleteService) {
		this.listService = listService;
		this.viewService = viewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.deleteService = deleteService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, 
			String uri) throws Exception {
		String jsp = "";
		
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"),
				request.getParameter("perpageNum"));
		
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		
		if(word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}
		
		switch (uri) {
		case "/notice/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject)); 
			jsp = "notice/list";
			break;
			
		case "/notice/view.do":
			System.out.println("noticeexecute");
			
			int no = Integer.parseInt(request.getParameter("no"));
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			
			request.setAttribute("dto", Execute.service(viewService, no, cnt));
			jsp ="notice/view";
			break;
			
		case "/notice/writeForm.do":
			jsp = "notice/writeForm";
			break;
			
		case "/notice/write.do":
			Execute.service(writeService, getDTO(request.getParameter("title"),
					request.getParameter("content"), request.getParameter("startDate"),
					request.getParameter("endDate")));
			
			jsp = "redirect:list.do?page=1&perPageNum="+request.getParameter("perPageNum");
			break;
			
		case "/notice/updateForm.do":
			no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("dto", Execute.service(viewService, no, 0));
			
			jsp = "notice/updateForm";
			break;
			
		case "/notice/update.do":
			no = Integer.parseInt(request.getParameter("no"));
			Execute.service(updateService, getDTO(no, request.getParameter("title"),
					request.getParameter("content"), request.getParameter("startDate"),
					request.getParameter("endDate")));
			
			jsp = "redirect:view.do?no=" + request.getParameter("no")
					+ "&cnt=0"
					+ "&page=" + pageObject.getPage()
					+ "&perPageNum=" + pageObject.getPerPageNum()
					+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
					? "&key=" + pageObject.getKey()
					+ "&word="
					+ URLEncoder.encode(pageObject.getWord(), "utf-8"):"");
			System.out.println("NoticeController.execute().jsp:"+jsp);
			break;
			
		case "/notice/delete.do":
			Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
			
			jsp = "redirect:list.do?page=1&perPageNum="
					+request.getParameter("perPageNum");
			break;
			
		default:
			break;
		}
		
		System.out.println("NoticeController.execute().jsp:"+jsp);
		return jsp;
	}
	
	private NoticeDTO getDTO(String title, String content, String startDate, String endDate) {
		// TODO Auto-generated method stub

		NoticeDTO dto = new NoticeDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		return dto;
	}
	
	private NoticeDTO getDTO(int no, String title, String content, String startDate, String endDate) {
		// TODO Auto-generated method stub

		NoticeDTO dto = getDTO(title, content, startDate, endDate);
		dto.setNo(no);
		return dto;
	}
	
	
}
