<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tl" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>

<!-- 이미지 다른 서버에서도 보려면 아래에 저장된 이미지를 upload 폴더에 옮겨야함 -->
<!-- D:\Workspace\Web\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\cafeatte\upload\userCafe\image -->



<html>
<head>
<meta charset="UTF-8">
<title>UserCafe List</title>

<style type="text/css">
.datarow:hover {
	background: #eee;
	cursor: pointer;
}
#img{
border-radius: 5px;
width: 100px;
height: 100px;

}
</style>
<script type="text/javascript">

	$(function() {
		//하나의 글 선택하면 글번호를 받아서 글보기로 보낸다. 
		$(".datarow").click(function(){
			var no = $(this).find(".no").text();
			location = "view.do?no="+no
					+"&cnt=1"
					+"&page=${pageObject.page}"
					+"&perPageNum=${pageObject.perPageNum}"
					${(!empty pageObject.word)?
							"+\"&key="+=pageObject.key+="&word="
							+=pageObject.word+="\"":""};
		});
		
		//페이지네이션
		$(".pagination > li:not('.active')").click(
			function(){
			var page = $(this).data("page");
			location="list.do?page="+page
					+"&perPageNum=${pageObject.perPageNum}"
					+"&key=${pageObject.key}"
					+"&word=${pageObject.word}";
			return false;
			});
		$("li.active").click(function(){
			return false;
		});
		//한페이지에 나타날 글의 갯수 변경
		$("#perPageRow").on({
			"change":function(){
				perPageNum = $("#perPageRow").val();
				location="list.do?page=1"
					+"&perPageNum=" + perPageNum
					+"&key=${pageObject.key}"
					+"&word=${pageObject.word}";
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div id="searchDiv" style="padding-bottom: 5px">

	<h1><br><strong>쉿! 회원들만 알고있는 힙한 카페 </strong></h1><br><br>
	 <!-- 검색 -->
			<form action="list.do" class="form-inline">
				<input name="page" value="1" type="hidden" /> <input
					name="perPageNum" value="${pageObject.perPageNum }" type="hidden" />
				<div class="form-group">
					<select class="form-control" id="key" name="key">
						<option value="t" ${(param.key=="t")?"selected='selected'":"" }>제목</option>
						<option value="c" ${(param.key=="c")?"selected='selected'":"" }>내용</option>
						<option value="n" ${(param.key=="n")?"selected='selected'":"" }>닉네임</option>
						<option value="tc" ${(param.key=="tc")?"selected='selected'":"" }>제목/내용</option>
						<option value="tn" ${(param.key=="tn")?"selected='selected'":"" }>제목/닉네임</option>
						<option value="cn" ${(param.key=="cn")?"selected='selected'":"" }>내용/닉네임</option>
						<option value="tcn"
							${(param.key=="tcn")?"selected='selected'":"" }>전체</option>

					</select>
				</div>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="word" value="${param.word }">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
				<div class="input-group right">
					<span class="input-group-addon">페이지당 게시글수</span> <select
						class="form-control" id="perPageRow">
						<option ${(pageObject.perPageNum==10)?"selected='selected'":""}>10</option>
						<option ${(pageObject.perPageNum==15)?"selected='selected'":""}>15</option>
						<option ${(pageObject.perPageNum==20)?"selected='selected'":""}>20</option>
						<option ${(pageObject.perPageNum==25)?"selected='selected'":""}>25</option>
					</select>
				</div>
			</form>

		</div>
	<div>
		<table class="table">
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>닉네임</td>
				<td>이미지</td>
				<td>작성일</td>
				<td>조회수</td>
				<td>좋아요</td>

			</tr>
			<!--dto에 넣는 순서를 UserCafeController의 getDTO 순서와 맞추어야 한다. -->
			<c:forEach items="${list }" var="dto" >
				<tr class="datarow" >
					<td class="no">${dto.no}</td>
					<td>${dto.title}</td>
					<td>${dto.nickName}</td>
					<td><img src="${dto.fileName}" id="img"></td>
					<td>${dto.writeDate}</td>
					<td>${dto.hit}</td>
					<td>${dto.cntLike}</td>
				</tr>
			</c:forEach>
		</table>

			<!-- 페이지네이션 -->
			<!-- pageNav.tag에서 taglibrary 만들어놔서 바로 쓸수있다. -->
		<div align="center">
		<ul class="pagination">
				<li data-page=1><a href="#">&lt;&lt;</a></li>
				
				<c:if test="${pageObject.startPage > 1 }">
					<li data-page=${pageObject.startPage -1 }><a href="#">&lt;</a>
					</li>
				</c:if>
				
				<c:forEach begin="${pageObject.startPage }"
					end="${pageObject.endPage }" var="cnt">
					<li ${(pageObject.page == cnt)?"class=\"active\"":"" }
						data-page=${cnt }><a>${cnt}</a></li>
				</c:forEach>
				
				<c:if test="${pageObject.endPage < pageObject.totalPage }">
					<li data-page=${pageObject.endPage + 1}><a href="#">&gt;</a>
					</li>
				</c:if>
				
				<li data-page=${pageObject.totalPage }><a href="#">&gt;&gt;</a>
				</li>
			</ul>
		</div>
		<div>
				<a href="writeForm.do"><button>글쓰기</button></a>
				<a href="list.do"><button>전체목록</button></a>
		</div>
	</div>
	</div>
</body>
</html>