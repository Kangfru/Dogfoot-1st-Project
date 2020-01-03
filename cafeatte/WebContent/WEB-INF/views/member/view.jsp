<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

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
    .mainDiv{
    	padding: 50px;
    }
    tr{
    	font-size: 20px;
    }
    body {
        font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
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
        width: 80%;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
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
	<div class="mainDiv">
		<div class="left">
			<img src="${dto.photo }" class="img-circle" width="60%">
			<p>프로필 사진</p>
		</div>
		<div class="right">
			<table class="table">
				<tr>
					<td>아이디</td><td>${dto.id }</td>
				</tr>
				<tr>
					<td>닉네임</td><td>${dto.nickName }</td>
				</tr>
				<tr>
					<td>주소</td><td>${dto.addr }</td>
				</tr>
				<tr>
					<td>이메일</td><td>${dto.email }</td>
				</tr>
				<tr>
					<td>전화번호</td><td>${dto.tel }</td>
				</tr>
			</table>
			<a href="checkPwForm.do"><button class="btn btn-default">개인정보 수정</button></a>
		</div>
	</div>

</body>
</html>