package com.cafeatte.magazine.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeatte.magazine.dto.MagazineDTO;
import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.member.dto.LoginDTO;
import com.cafeatte.util.io.FileUtil;
import com.cafeatte.util.page.PageObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webjjang.util.ImageResizing;

public class MagazineController implements Controller {

		private Service listService; 
		private Service viewService; 
		private Service writeService; 
		private Service updateService; 
		private Service deleteService;
		private Service mlistService; 
		 

		// 생성자를 이용해서 service DI(Dependent 적용 --> Beans에서 생성 후 넣어 준다. 
		public MagazineController(
				Service listService,
				Service viewService,
				Service writeService,
				Service updateService,
				Service deleteService, 
			    Service mlistService
				
				) {
			
			
			// TODO Auto-generated constructor stub
			this.listService = listService;
			this.viewService = viewService;
			this.writeService = writeService;
			this.updateService = updateService;			
			this.deleteService = deleteService;
			this.mlistService = mlistService;
			
			
		}
		
		// **** 첨부파일에서 사용되는 변수
				// 로그인 정보에서 아이디를 받는다. - 현재는 강제로그인.
//				String id = "kangfru";
				// 매거진 파일이 들어 있는 데이터 받기 처리
				// 첨부파일의 용량제한
				int size = 100*1024*1024;
				// 파일을 업로드할 웹의 위치 - 사이트 메시의 적용을 받지 않는 위치
				String path = "/upload/magazine/image/";
				
				// 글번호 변수
				String noStr = "";
				// 한페이지에 표시할 데이터의 갯수
				String perPageNumStr = "12";
				
				//데이버 수정이나 삭제시 지워야할 파일
				String deleteFileName = null;
				private String subTitle;
				private String writeDate;
				private String startDate;
				private String endDate;
				
				
				
			

		@Override
		public String execute(HttpServletRequest request,
				HttpServletResponse response, String uri) 
				throws Exception {
			// TODO Auto-generated method stub
			
			// 공통으로 사용되는 변수 (초기값셋팅)
			String jsp = "";
			
			PageObject pageObject = PageObject.getInstanceMagazine(request.getParameter("page"), 
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
			case "/magazine/list.do":
				
				request.setAttribute("pageObject", pageObject);
				request.setAttribute("list", Execute.service(listService,pageObject));
				request.setAttribute("mlist", Execute.service(mlistService,pageObject));
				System.out.println("매거진 리스트 처리 ");
				// jsp 파일 정하기
				jsp = "magazine/list";
				break;
	
			case "/magazine/view.do":	
				//request에 실행한 결과 값을 저장 -> jsp에서 꺼내 쓴다. 

				request.setAttribute("dto", Execute.service(viewService,
						Integer.parseInt(request.getParameter("no")),
						Integer.parseInt(request.getParameter("cnt"))));
				System.out.println("매거진 view.do====================");
								
				jsp = "magazine/view";
				
				break;
			//매거진 글 쓰기 폼
			case "/magazine/writeForm.do":	
				
				jsp = "magazine/writeForm";
				break;
			
		    // 매거진 글 처리 
			case "/magazine/write.do":	
				// 데이터를 받아 dto를 만든 후 서비스에 전달해서 DB에 글쓰기를 한다.
				System.out.println(request.getParameter("startDate"));
				Execute.service(writeService, 
						getDTO(request));
					// 자동으로 리스트로 이동시켜야 한다.
					jsp ="redirect:list.do?page=1&perPageNum="
//						+multi.getParameter("perPageNum");
							+perPageNumStr;
					break;
			case "/magazine/updateForm.do":
				// 글번호를 받는다.
				request.setAttribute("dto", Execute.service(viewService,
						Integer.parseInt(request.getParameter("no")),
						Integer.parseInt(request.getParameter("cnt"))));
				// 자동으로 리스트로 이동시켜야 한다.
				jsp = "magazine/updateForm";
				break;

			case "/magazine/update.do":
				MagazineDTO dto = getDTO(request);
				
				// 글번호를 받는다.
				Execute.service(updateService, dto);
				//전달된 첨부파일이 있는 경우 매거진 교체를 해야 하므로 원래 있었던 파일을 지운다. 
				if(dto.getFileName()!= null) 
					FileUtil.deleteFile
					(FileUtil.realPath(request, deleteFileName));
				int pos = deleteFileName.lastIndexOf("/");
				deleteFileName = deleteFileName.substring(0,pos + 1 ) + "s_" + deleteFileName.substring(pos+1);
				FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName));
				// 자동으로 리스트로 이동시켜야 한다.
				jsp = "redirect:view.do?no=" + noStr
						+ "&cnt=0&page="+pageObject.getPage()
						+ "&perPageNum=" + pageObject.getPerPageNum()
						+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
							?"&key="+ pageObject.getKey() 
							+ "&word=" 
							// 서버의 한글 코드가 ISO-8859-1를 사용하므로 맞지 않으므로
							// 데이터를 꺼내서 붙이면 코드 변환 문제를 해결해야 한다. 
							// 검색어가 한글인 경우 엔코딩해서 넘긴다.
							+ URLEncoder.encode(pageObject.getWord(),"utf-8"):"");
				System.out.println("MagazineController.execute().jsp:" + jsp);
				break;
				
				// 매거진 글삭제
			case "/magazine/delete.do":	
				
				
				//반드시 리스트에서 부터 들어와야한다.
				deleteFileName = request.getParameter("deleteFile");
				Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
				FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName));
				int pos1 = deleteFileName.lastIndexOf("/");
				deleteFileName = deleteFileName.substring(0,pos1 + 1 ) + "s_" + deleteFileName.substring(pos1+1);
				FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName));
				
				// 자동으로 리스트로 이동 시켜야 한다. 
				jsp ="redirect:list.do?page=1&perPageNum="
						+request.getParameter("perPageNum");
				

				break;

			default:
				break;
			}
			System.out.println("MagazineController.execute().jsp"+jsp);
			return jsp;
		}

//private String setperPageNum(int i) {
//			// TODO Auto-generated method stub
//			return null;
//		}

		// 주로 글쓰기 할 때 사용되는 메서드 
		private MagazineDTO getDTO(
				String title, 
				String subTitle,
				String content, 
				String id, 
				String fileName,
				String startDate,
				String endDate
				){
			MagazineDTO dto = new MagazineDTO();
			dto.setTitle(title);
			dto.setSubTitle(subTitle);
			dto.setContent(content);
			dto.setStartDate(startDate);
			dto.setEndDate(endDate);
			dto.setId(id);
			System.out.println("getDTO() + id" + id);
			// 매거진 등록 시 에는 반드시 입력되어야 한다.
			// 그러나 수정 시에는 매거진를 그대로 사용하고자 할때는 변경되지 않는다. -> 데이터가 들어오지 않는다.
			if(fileName != null && !fileName.equals("") 
			&& !fileName.equals(path+"null"))
			dto.setFileName(fileName);
			return dto;
		}
		// 주로 글수정 할때 사용되는 메서드 
		private MagazineDTO getDTO(int no, String title,String subTitle,
				String content, String id, String fileName, String startDate, String endDate) {
			MagazineDTO dto = getDTO(title, subTitle, content, id, fileName, startDate, endDate);
			dto.setNo(no);
			return dto;
		}
		
		// 쓰기나 수정하는 경우 이 메서드 부터 시작이 된다. -> no가 있으면 수정, 없으면 쓰기
		private MagazineDTO getDTO(HttpServletRequest request) throws Exception {
			HttpSession session = request.getSession();
			LoginDTO dto = (LoginDTO) session.getAttribute("login");
			String id = dto.getId();
			String uploadPath = FileUtil.realPath(request,path);
//			String uploadPath = request.getServletContext().getRealPath(path);
			System.out.println(uploadPath);
			//new MultipartRequest(request, 파일이올라간하드디스크의위치와파일명, 
			// 용량제한, 엔코딩, 중복처리프로그램)- 생성이 되면 첨부파일이 바로 올라 간다.
			MultipartRequest multi = new MultipartRequest(request, uploadPath,
			size, "utf-8",	new DefaultFileRenamePolicy());

			// DB에 저장할 첨부파일 정보 : 웹위치+서버의파일명
			String fileName = path + multi.getFilesystemName("fileName");
			System.out.println("여기 1MagazineController.execute().fileName:" + fileName);
			
			// 저장된 파일 사이즈를 줄여서 리스트에 표시 하기 위한 파일로 복사 -> dog01.jpg -> s_dog01.jpg
			// webjjangma 카페에서 업로드 검색 리사이징 프로그램 참조 + 라이브러리 등록 해서 사용. 
			//MagazineResizing.magazineResizing(realPath, fileName(매거진 파일명), 앞첨자, 너비, 높이)
			//첨부파일이 있는 경우만 처리를 한다. 첨부가 없는 경우는 fileName 
			if(fileName != null && !fileName.equals("") 
					&& !fileName.equals(path + "null"))
			ImageResizing.imageResizing(uploadPath, 
					multi.getFilesystemName("fileName"), "s_", 300);
			
			// 한페이지에 표시할 데이터의 갯수
			perPageNumStr = multi.getParameter("perPageNum");

			noStr = multi.getParameter("no");
			System.out.println("여기2MagazineController.execute().fileName:" + fileName);

			// 글번호가 들어오면 - 업데이터(수정)
			if(noStr != null && !noStr.equals("")) {
			deleteFileName = multi.getParameter("deleteFile");
			System.out.println("deleteFileName : " + deleteFileName);
			
			
			return getDTO(Integer.parseInt(noStr),
						multi.getParameter("title"),
						multi.getParameter("subTitle"),
						multi.getParameter("content"), id, fileName, multi.getParameter("startDate") , multi.getParameter("endDate"));
			}
			// 글번호가 들어오지 않으면 - 글쓰기
			return getDTO( 
						multi.getParameter("title"), 
						multi.getParameter("subTitle"), 
						multi.getParameter("content"), 
						id,fileName,
						multi.getParameter("startDate"), 
						multi.getParameter("endDate") 
						);
		}
	}

