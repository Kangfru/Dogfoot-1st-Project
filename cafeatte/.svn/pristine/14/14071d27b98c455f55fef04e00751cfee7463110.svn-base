package com.cafeatte.coupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeatte.coupon.dto.CouponDTO;
import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.member.dto.LoginDTO;
import com.cafeatte.member.dto.MemberDTO;
import com.cafeatte.util.io.FileUtil;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webjjang.util.ImageResizing;

public class CouponController implements Controller {

	private Service sendService, listService, viewService, useService, updateService;
	
	public CouponController(Service sendService, Service listService, Service viewService, Service useService, Service updateService) {
		this.sendService = sendService;
		this.listService = listService;
		this.viewService = viewService;
		this.useService = useService;
		this.updateService = updateService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		String jsp = "";
		HttpSession session = request.getSession();
		
		switch (uri) {
		case "/coupon/sendForm.do":
			jsp = "coupon/sendForm";
			break;
			
		case "/coupon/send.do":
			String uploadPath = request.getServletContext().getRealPath("upload/coupon/images");
			String path = "/upload/coupon/images/";
			MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
			String fileName = path + multi.getFilesystemName("fileName");
			if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
				ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("fileName"), "s_", 100);
			}
			
			CouponDTO dto = new CouponDTO();
			dto.setSender(((LoginDTO) session.getAttribute("login")).getId());
			dto.setTitle(multi.getParameter("title"));
			dto.setContent(multi.getParameter("content"));
			dto.setFileName(fileName);
			dto.setCafe_no(Integer.parseInt(multi.getParameter("cafe_no")));
			dto.setEndDate(multi.getParameter("endDate"));
			System.out.println(dto);
			Execute.service(sendService, dto);
			getDTOFromSessionToAttribute(request, session);
			jsp = "coupon/list";
			break;

		case "/coupon/list.do":
			getDTOFromSessionToAttribute(request, session);
			jsp = "coupon/list";
			break;

		case "/coupon/view.do":
			int viewCno = Integer.parseInt(request.getParameter("cno"));
			System.out.println(viewCno);
			request.setAttribute("dto", Execute.service(viewService, viewCno));
			jsp = "coupon/view";
			break;
			
		case "/coupon/use.do":
			Execute.service(useService, getDTO((String)(((LoginDTO) session.getAttribute("login")).getId()), request));
			getDTOFromSessionToAttribute(request, session);
			jsp = "coupon/list";
			break;
		
		case "/coupon/delete.do":
			Execute.service(useService, getDTO((String)(((LoginDTO) session.getAttribute("login")).getId()), request));
			getDTOFromSessionToAttribute(request, session);
			jsp = "coupon/list";
			break;
		
		case "/coupon/updateForm.do":
			request.setAttribute("dto", Execute.service(viewService, Integer.parseInt(request.getParameter("cno"))));
			jsp = "coupon/updateForm";
			break;
			
		case "/coupon/update.do":
			CouponDTO dto1 = upDTO(request);
			Execute.service(updateService, dto1);
			jsp = "redirect:view.do?cno=" + dto1.getCno();
			break;
			
		default:
			break;
		}
		
		
		return jsp;
	}
	private CouponDTO getDTO(String id, HttpServletRequest request) {
		CouponDTO dto = new CouponDTO();
		dto.setUsedId(id);
		dto.setCno(Integer.parseInt(request.getParameter("cno")));
		dto.setCafe_no(Integer.parseInt(request.getParameter("cafe_no")));
		return dto;
	}
	
	private void getDTOFromSessionToAttribute (HttpServletRequest request, HttpSession session) throws Exception{
		LoginDTO viewDTO = (LoginDTO) session.getAttribute("login");
		String id = viewDTO.getId();
		request.setAttribute("list", Execute.service(listService, id));
	}
	
	private CouponDTO upDTO(HttpServletRequest request) throws Exception {
		CouponDTO dto = new CouponDTO();
		String uploadPath = request.getServletContext().getRealPath("upload/coupon/images");
		String path = "/upload/coupon/images/";
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		String fileName = path + multi.getFilesystemName("upPhoto");
		if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
			ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("upPhoto"), "s_", 100);
			FileUtil.deleteFile(FileUtil.realPath(request, multi.getParameter("fileName")));
			String smallPhoto = multi.getParameter("fileName");
			int pos = smallPhoto.lastIndexOf("/");
			smallPhoto = smallPhoto.substring(0, pos + 1) + "s_" + smallPhoto.substring(pos + 1);
			FileUtil.deleteFile(FileUtil.realPath(request, smallPhoto));
		}
		System.out.println("upDTO" + multi.getOriginalFileName("upPhoto"));
		dto.setTitle(multi.getParameter("title"));
		dto.setContent(multi.getParameter("content"));
		dto.setEndDate(multi.getParameter("endDate"));
		dto.setCafe_no(Integer.parseInt(multi.getParameter("cafe_no")));
		dto.setCno(Integer.parseInt(multi.getParameter("cno")));
		if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
			dto.setFileName(fileName);
		} else {
			dto.setFileName(multi.getParameter("fileName"));
		}
		System.out.println(dto);
		return dto;
	}
}
