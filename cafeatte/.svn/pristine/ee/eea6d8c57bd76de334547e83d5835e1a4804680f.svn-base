<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>

<body>
	<div class="container">
		<h2>아이디 찾기</h2>
		<form action="findId.do" method="post" id="findIdForm">
				<div class="form-group">
					<label for="email">이메일 : </label> <input type="text"
						class="form-control" id="email" placeholder="Enter email"
						maxlength="20" required="required" pattern="^.{4,20}$"
						title="4-20이내의 글자 입력" name="email" />
				</div>
			<button type="submit" class="btn btn-default" id="findIdBtn">아이디 찾기</button>
			</form>
			<div id="findIdDiv"></div>
			<hr/>
			<hr/>
			<form action="findPwForm.do" method="post" id="findPwForm">
				<div class="form-group">
				<label for="ID">아이디 : </label> <input type="text"
					class="form-control" id="id" placeholder="Enter ID" maxlength="20"
					required="required" pattern="^[A-Za-z][A-za-z0-9]{3,19}$"
					title="4-20영숫자, 맨 앞자는 영문자" name="id" />
				</div>
				<div class="form-group">
					<label for="email2">이메일 : </label> <input type="text"
						class="form-control" id="email2" placeholder="Enter email"
						maxlength="20" required="required" pattern="^.{4,20}$"
						title="4-20이내의 글자 입력" name="email2" />
				</div>
			<button type="submit" class="btn btn-default" id="findPwBtn">비밀번호 찾기</button>
		</form>
		<div id="findPwDiv"></div>
		<hr/>
	</div>
	
	<script type="text/javascript">
	$(function(){
		$("#findIdBtn").on("click", function(event){
			event.preventDefault();
			var email = $("#email").val();
			$("#findIdDiv").load("/ajax/findId.do", {email: email}, function(data, status, jqXGR) {  // callback function 
				if(data.indexOf("없습니다.") != -1){
					$("#email").focus(); 
					return false;
				} else {
					$("#findIdForm").submit();
				}
			});
		});
		
		$("#findPwBtn").on("click", function(event){
			event.preventDefault();
			var id = $("#id").val();
			var email2 = $("#email2").val();
			$("#findPwDiv").load("/ajax/findPwForm.do", {id:id, email2: email2}, function(data, status, jqXGR) {  // callback function 
				if(data.indexOf("확인해주세요.") != -1){
					$("#id").focus(); 
					return false;
				} else {
					$("#findPwForm").submit();
				}
			});
		});
	});
	
	</script>
</body>
</html>