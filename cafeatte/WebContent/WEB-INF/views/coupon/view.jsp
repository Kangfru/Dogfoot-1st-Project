<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 보기 </title>
<style>
.left {
	width: 50%;
	float: left;
	box-sizing: border-box;
}

.right {
	width: 50%;
	float: right;
	box-sizing: border-box;
}

.mainDiv {
	padding: 50px;
}

tr {
	font-size: 20px;
}

.showing {
	display: block;
}

.select {
	display: none;
}

body {
	font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
		Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}

 button { 
 	all: unset; 
 	background-color: steelblue; 
 	color: white; 
 	padding: 5px 20px; 
 	border-radius: 5px; 
 	cursor: pointer; 
 }
.modal {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.modal__overlay {
	background-color: rgba(0, 0, 0, 0.6);
	width: 100%;
	height: 100%;
	position: absolute;
}

.modal__content {
	background-color: white;
	padding: 50px 100px;
	text-align: center;
	position: relative;
	border-radius: 10px;
	width: 50%;
	height: 50%;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px
		rgba(0, 0, 0, 0.23);
}

h1 {
	margin: 0;
}

.hidden {
	display: none;
}
</style>
</head>
<body>
	<h1>쿠폰 보기</h1>
	<table class="table" >
		<tr>
			<th>쿠폰 번호</th><td>${dto.cno }</td>
		</tr>
		<tr>	
			<th>제목</th><td>${dto.title }</td>
		</tr>
		<tr>	
			<th>내용</th><td>${dto.content }</td>
		</tr>
		<tr>
			<th>이미지</th><td><img alt="" src="${dto.fileName }"></td>
		</tr>
		<tr>
			<th>만료일</th><td><pre>${dto.endDate }</pre></td>
		</tr>
		<tr>
			<th>보낸 이</th><td>${dto.sender }</td>
		</tr>
		
		<tr>
			<th>카페 정보</th><td>${dto.cafe_no }</td>
		</tr>
		<tr>
			<td colspan="2">	
				<a href ="use.do?cno=${dto.cno }&cafe_no=${dto.cafe_no }"><button class="btn btn-success" id="useBtn">사용하기</button></a>
				<a href ="delete.do?cno=${dto.cno }&cafe_no=${dto.cafe_no }"><button class="btn btn-warning" id="deleteBtn">삭제하기</button></a>
				<c:if test="${!empty login }">
					<c:if test="${login.grade==9 }">
						<a href="/coupon/updateForm.do?cno=${dto.cno }"><button class="btn btn-default">수정하기</button></a>
					</c:if>
				</c:if>
			</td>
		</tr>
	</table>
	<div class="modal hidden">
        <div class="modal__overlay"></div>
        <div class="modal__content">
            <h1>사용하시겠습니까?</h1>
            <h3>매장 직원 이신 경우 누르시길 바라며 잘못 사용 시 책임지지 않습니다.</h3>
            <div class="changeDiv"></div>
            <button class="modalAccept">사용하기</button>
            <button class="modalClose">취소</button>
        </div>
    </div>
	<script type="text/javascript">
		const useBtn = document.querySelector("#useBtn");
		const modal = document.querySelector(".modal");
        const overlay = modal.querySelector(".modal__overlay");
        const modalClose = modal.querySelector(".modalClose");
        const modalAccept = modal.querySelector(".modalAccept");
        const changeDiv = modal.querySelector(".changeDiv");
        
		useBtn.addEventListener("click", useBtnClick);
        modalAccept.addEventListener("click", acceptModal);
        modalClose.addEventListener("click", closeModal);
		
        function acceptModal(){
        	closeModal();
        	location.href="/coupon/use.do?cno=${dto.cno }&cafe_no=${dto.cafe_no }";
        }
        
		function closeModal(){
        	modal.classList.add("hidden");
        }
		
		function modalPopUp(){
			modal.classList.remove("hidden");
		}

		function useBtnClick(event){
			event.preventDefault();
			modalPopUp();
		}
	</script>
</body>
</html>