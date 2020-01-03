package com.cafeatte.qna.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeatte.magazine.dto.MagazineDTO;
import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.member.dto.LoginDTO;
import com.cafeatte.qna.dto.QnaDTO;
import com.cafeatte.util.io.FileUtil;
import com.cafeatte.util.page.PageObject;



public class QnaController implements Controller {

	private Service listService; 
	private Service viewService; 
	private Service writeService; 
	private Service updateService; 
	private Service deleteService; 
	private Service answerService;
	

	// 생성자를 이용해서 service DI(Dependent 적용 --> Beans에서 생성 후 넣어 준다. 
	public QnaController(
			Service listService,
			Service viewService,
			Service writeService,
			Service updateService,
			Service deleteService, 
		    Service answerService 
		   ){
		// TODO Auto-generated constructor stub
		
		this.listService = listService;
		this.viewService = viewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.deleteService = deleteService;
		this.answerService = answerService;
	}
	
	
	// 글번호 변수
	String noStr = "";
	// 한페이지에 표시할 데이터의 갯수
	String perPageNumStr = "";
	
	//데이버 수정이나 삭제시 지워야할 파일
	String deleteFileName = null;
	
	
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, String uri) 
			throws Exception {
		// TODO Auto-generated method stub
		
		// 공통으로 사용되는 변수 (초기값셋팅)
		String jsp = "";
		PageObject pageObject =PageObject.getInstance(request.getParameter("page"), 
				request.getParameter("perPageNum"));
		
		// 검색에 대한 데이터 셋팅
					String key = request.getParameter("key");
					String word = request.getParameter("word");
					if(word != null) {
						
						pageObject.setKey(key);
						pageObject.setWord(word);
					}	
				
		//jsp에서 자바 부분을 여기에 넣는다. 
		switch(uri) {
		case "/qna/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService,pageObject));
			
			jsp = "qna/list";
			
			break;

		case "/qna/view.do":	
			
			request.setAttribute("dto", Execute.service(viewService, 
			 Integer.parseInt(request.getParameter("no")),   
			 Integer.parseInt(request.getParameter("cnt"))));   
		
			System.out.println("질문답변 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			jsp = "qna/view";
			
			break;
			
//		case "/qna/view2.do":	
//			
//			request.setAttribute("dto", Execute.service(viewService, 
//					Integer.parseInt(request.getParameter("no")),   
//					Integer.parseInt(request.getParameter("cnt"))));  
//			
//			request.setAttribute("dto1", Execute.service(viewService, 
//					Integer.parseInt(request.getParameter("ordNo")),   
//					Integer.parseInt(request.getParameter("cnt"))));   
//			
//			System.out.println("답변 ======================================================");
//			jsp = "qna/view2";
			
//			break;
			
		case "/qna/qwriteForm.do":	
			jsp = "qna/qwriteForm";
			break;
		
		case "/qna/qwrite.do":	
			
			System.out.println("질문 쓰기 실행 ===============");
			Execute.service(writeService,getDTO(request));
			System.out.println("질문 쓰기 성공 ===============");
			
			// 자동으로 리스트로 이동시켜야 한다.
			jsp ="redirect:list.do?page=1&perPageNum="
					+request.getParameter("perPageNum");
			break;
		
		case "/qna/awriteForm.do":	
			request.setAttribute("dto", Execute.service(viewService,
					Integer.parseInt(request.getParameter("no")),
					Integer.parseInt(request.getParameter("cnt"))));
			// 자동으로 리스트로 이동시켜야 한다.
			jsp = "qna/awriteForm";
			
			break;
			
		case "/qna/answer.do":	
			QnaDTO dto = getDTO(request);
			System.out.println("ans : " + dto);
			dto.setOperateNo(dto);
			Execute.service(answerService, dto);
			
			jsp = "redirect:view.do?no=" + (Integer.parseInt(noStr)+1)
					+ "&cnt=0&page="+pageObject.getPage()
					+ "&perPageNum=" + pageObject.getPerPageNum()
					+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
						?"&key="+ pageObject.getKey() 
						+ "&word=" 
					
						+ URLEncoder.encode(pageObject.getWord(),"utf-8"):"");
			System.out.println("qnaController.execute().jsp:" + jsp);
			break;
			
		case "/qna/updateForm.do":
			// 글번호를 받는다.
			request.setAttribute("dto", Execute.service(viewService,
					Integer.parseInt(request.getParameter("no")),
					Integer.parseInt(request.getParameter("cnt"))));
			// 자동으로 리스트로 이동시켜야 한다.
			jsp = "qna/updateForm";
			break;

		case "/qna/update.do":
			QnaDTO dto2 = getDTO(request);
			
			// 글번호를 받는다.
			Execute.service(updateService, dto2);
			
			jsp = "redirect:view.do?no=" + noStr
					+ "&cnt=0&page="+pageObject.getPage()
					+ "&perPageNum=" + pageObject.getPerPageNum()
					+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
						?"&key="+ pageObject.getKey() 
						+ "&word=" 
					
						+ URLEncoder.encode(pageObject.getWord(),"utf-8"):"");
			System.out.println("qnaController.execute().jsp:" + jsp);
			break;
			
			
		case "/qna/delete.do":	
			 
			Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
			jsp = "redirect:list.do";
			break;
		
				
		default:
			break;
		}
		System.out.println("QnaController.execute().jsp"+jsp);
		return jsp;
	}


//	// 답글 작성용 메서드
//	private QnaDTO getDTO(String id, int no, String title, String content, String writeDate,
//		int refNo, int ordNo, int levNo, int parentNo) {
//		QnaDTO dto = getDTO( id, title, content, writeDate,refNo,ordNo,levNo,parentNo);
//		
//		dto.setNo(no);
//		return dto;
//	}
	
	// 답글 작성용 메서드, 글 수정
	private QnaDTO getDTO(String id, int no, String title, String content, String writeDate,
			int refNo, int ordNo, int levNo, int parentNo) {
		QnaDTO dto = new QnaDTO();
		dto.setId(id);
		dto.setNo(no);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriteDate(writeDate);
		dto.setRefNo(refNo);
		dto.setOrdNo(ordNo);
		dto.setLevNo(levNo);
		dto.setParentNo(parentNo);
		return dto;
	}
	
	//글 생성 사용 메서드
	private QnaDTO getDTO(String id, String title,String content) {
		
			QnaDTO dto = new QnaDTO();
			
			dto.setId(id);
			dto.setTitle(title);
			dto.setContent(content);
			
			return dto;
		}

	// 쓰기나 수정하는 경우 이 메서드 부터 시작이 된다. -> no가 있으면 수정, 없으면 쓰기
	private QnaDTO getDTO(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		LoginDTO dto = (LoginDTO) session.getAttribute("login");
		System.out.println("id : "+dto.getId());
		String id = dto.getId();

		
		// 한페이지에 표시할 데이터의 갯수
		perPageNumStr = request.getParameter("perPageNum");

		noStr = request.getParameter("no");
		System.out.println("넘버 : " + noStr);
		
		// 글번호가 들어오면 - 업데이터(수정)
		if(noStr != null && !noStr.equals("")) {
		System.out.println("관련글 : " + request.getParameter("refNo"));
		System.out.println("들여쓰기번호: " + request.getParameter("levNo"));
		System.out.println("순서번호 : " + request.getParameter("ordNo"));
		System.out.println("부모 : " + request.getParameter("parentNo"));
		return getDTO(id, Integer.parseInt(noStr),
				request.getParameter("title"),
				request.getParameter("content"), 
				request.getParameter("writeDate"),
				Integer.parseInt(request.getParameter("refNo")),
				Integer.parseInt(request.getParameter("ordNo")),
				Integer.parseInt(request.getParameter("levNo")),
				Integer.parseInt(request.getParameter("parentNo")));
		}
		
		// 글번호가 들어오지 않으면 - 글쓰기
		return getDTO( id, request.getParameter("title"), request.getParameter("content"));
		}

}

