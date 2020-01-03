<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style type="text/css">
.dataRow:hover {
	background: #fff;
	color: orange;
	cursor: pointer;
}
.dataRow2:hover {
	background: #fff;
	color: orange;
	cursor: pointer;
}
.dataRow3:hover {
	background: #fff;
	color: orange;
	cursor: pointer;
}

ul {
	padding: 0px 0;
}

ul li {
	display: inline-block;
	margin: 2px 2px;
	font-size: 14px;
	letter-spacing: -.5px;
}

ul li.tag-item {
	padding: 4px 8px;
	list-style: none;
	background-color: #000;
	color: #fff;
}

ul li.searchTag-item {
	padding: 4px 8px;
	list-style: none;
	background-color: #000;
	color: #fff;
}

.tag-item:hover {
	background-color: orange;
	color: #fff;
}

.searchTag-item:hover {
	background-color: orange;
	color: #fff;
}

.img-rounded{
width:270px;
height: 270px;
}
.thumbnail{
width: 175px;
height: 175px;
}
#imgUser{
border-radius: 5px;
width: 100px;
height: 100px;

}
</style>
</head>
<body>
	<div>
		<h2>동네카페 리스트</h2>
	</div>
	<br>
	<br>
	<div class="row">
		<c:forEach var="dto" items="${cafeList}">
			<div class="col-md-2 imgsDiv"
				style="padding-right: 0px; padding-left: 0px; max-width: 210px">
				<div class="img-thumbnail">
					<div class="dataRow">
						<img src="${dto.fileName1 }" alt="${dto.fileName1 }"
							id="ListImage" class="img-responsive"> <input type="hidden"
							class="no" value="${dto.no }">
						<div class="title">
							<font size="20px"><b>${dto.title }</b></font>
						</div>
					</div>
					<div class="caption">
						<div id="hTags" style="hteight: 20%">
							<ul id="tag-list">
								<c:forEach var="hTags" items="${hTags }">
									<c:if test="${hTags.no == dto.no }">
										<li class='tag-item searchTag-item'>${hTags.hTag }</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
						<div class="writeDate" align="right" style="color: #bbb">
							${dto.writeDate }</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div >
	<hr/>
	<h2> 추천 매거진 리스트 </h2>
	
		<!-- 매거진  메인 리스트 작성  -->
		<span class="row">
		<!-- 데이터가 있는 만큼 반복문 처리 시작   -->
		    <c:forEach items="${mlist }" var="dto">
		    <!-- col시작 : no,title,id,writeDate,fileName -->
		    <div class="col-md-4" align="center">
		      <div class="dataRow2" style="max-width: 300px;" align="center">
		        <div align="left"> 조회수 : ${dto.hit }</div>
		          <img src="${dto.fileName }" class="img-rounded" alt="Lights" > 
		          <div class="caption">
		          <p><span class="no" style="display: none;">${dto.no }</span></p>
		            <b>${dto.title }</b> <br> 
		            ${dto.subTitle }
					<p>(${dto.startDate })(${dto.endDate })</p>
					  	        
		          </div>
		    
		      </div>
		    </div>
		 	<!-- col의 끝 -->
		 	</c:forEach>
		<!-- 데이터가 있는 만큼 반복문 처리 끝  -->
		 </span>
	</div>	
	<hr/>
	<h2>유저 추천 카페</h2>
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
			<c:forEach items="${userCafeList }" var="dto" >
				<tr class="dataRow3" >
					<td class="no">${dto.no}</td>
					<td>${dto.title}</td>
					<td>${dto.nickName}</td>
					<td><img src="${dto.fileName}" id="imgUser"></td>
					<td>${dto.writeDate}</td>
					<td>${dto.hit}</td>
					<td>${dto.cntLike}</td>
				</tr>
			</c:forEach>
		</table>	
		</div>
	
	
	
	<script type="text/javascript">
	$(document).ready(function() {
		$(function(){
			$(".searchTag-item").click(function(){
				var word = $(this).text();
				if(word === "#전체"){
					word = "";
				}
				location="/cafe/list.do?page=1"
					+ "&perPageNum=${pageObject.perPageNum}"
					+ "&word="+word;
			})
		});
		
		$(".dataRow").click(function() {
			no = $(this).find(".no").val();
			location = "/cafe/view.do?no=" + no
			+ "&cnt=1"
			+ "&page=${pageObject.page}"
			+ "&perPageNum=${pageObject.perPageNum}"
			//el 객체에서 empty -> null || ""체크 -> 데이터가 넘어오지 않았다.
			//el 객체에서 문자열 연결을 "+"로 사용 불가능 -> "+="으로 사용
		   ${(!empty pageObject.word)?
				   " + \"&word="
				   += pageObject.word +="\"":"" };
		});
		
		$(".dataRow2").click(function() {
			var no = $(this).find(".no").text();
			location = "/magazine/view.do?no=" + no 
					+ "&cnt=1"
		});
	});
	
	$(".dataRow3").click(function(){
		var no = $(this).find(".no").text();
		location = "/userCafe/view.do?no="+no
				+"&cnt=1"
				+"&page=${pageObject.page}"
				+"&perPageNum=${pageObject.perPageNum}"
				${(!empty pageObject.word)?
						"+\"&key="+=pageObject.key+="&word="
						+=pageObject.word+="\"":""};
	});
	</script>
</body>
</html>