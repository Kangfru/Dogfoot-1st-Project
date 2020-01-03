<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>

<body>
	<div class="container">
		<h2>비밀번호 찾기</h2>
			<hr/>
				<div class="form-group">
					<span>비밀번호 찾기 질문</span>
					<span>${dto.question }</span>
				</div>
			<form action="findPw.do" method="post" id="findPwForm">
				<div class="form-group">
				<input type="hidden" name="id" value="${dto.id }"/>
				<input type="hidden" name="pwEmail" value="${dto.email }"/>
					<label for="email">비밀번호 찾기 답  : </label> <input type="text"
						class="form-control" id="answer" placeholder="비밀번호 찾기 답"
						required="required"
						title="비밀번호 찾기 답" name="answer" />
				</div>
			<button type="submit" class="btn btn-default" id="findPwBtn">비밀번호 찾기</button>
		</form>
		<div id="findPwDiv"></div>
		<hr/>
	</div>
	<script type="text/javascript">
	$(function(){		
		$("#findPwBtn").on("click", function(event){
			event.preventDefault();
			var answer = $("#answer").val();
			$("#findPwDiv").load("/ajax/findPw.do", {id:'${dto.id}', answer: answer}, function(data, status, jqXGR) {  // callback function 
				if(data.indexOf("다릅니다.") != -1){
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