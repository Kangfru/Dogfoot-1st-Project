<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>

<body>
	<div class="container">
		<h2>로그인</h2>
		<div id="mainCheck">
		<form action="login.do" method="post" id="loginForm">
			<div class="form-group">
				<label for="ID">ID : </label> <input type="text"
					class="form-control" id="id" placeholder="Enter ID" maxlength="20"
					required="required" pattern="^[A-Za-z][A-za-z0-9]{3,19}$"
					title="4-20영숫자, 맨 앞자는 영문자" name="id" />
			</div>
			<div class="form-group">
				<label for="pw">비밀번호 : </label> <input type="password"
					class="form-control" id="pw" placeholder="Enter password"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20이내의 글자 입력" name="pw" />
			</div>
			<button type="submit" class="btn btn-default" id="loginBtn">Login</button>
			<div id="idPwResult"></div>
		</form>
		</div>
		<hr/>
		<h3>아직 카페어때의 멤버가 아니세요? 가입을 통해 다양한 혜택과 정보를 누려보세요!</h3>
		<a href="joinForm.do"><button class="btn btn-default">Sign in</button></a>
		<hr/>
		<h3>아이디나 비밀번호가 기억 안나시나요?  <a href="findIdPwForm.do" style="text-decoration: underline;">아이디/비밀번호 찾기</a></h3>
	</div>
	
	<script type="text/javascript">
	$(function(){
		$("#loginBtn").on("click", function(event){
			event.preventDefault();
			var id = $("#id").val().trim();
			var pw = $("#pw").val().trim();
			$("#idPwResult").load("/ajax/loginCheck.do", {id: id, pw: pw}, function(data, status, jqXGR) {  // callback function 
				if(data.indexOf("틀립니다.") != -1){
					$("#id").focus();
					return false;
				} else {
					$("#loginForm").submit();
				}
			
			});
		
		});
				
	});
	</script>
</body>
</html>