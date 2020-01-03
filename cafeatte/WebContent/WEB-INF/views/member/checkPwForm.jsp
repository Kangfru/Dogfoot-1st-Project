<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<div class="container">
		<h2>보안을 위해 비밀번호를 한 번 더 입력해주시기 바랍니다.</h2>
		<form action="checkPw.do" method="post" id="checkPwForm">
<%-- 			<input type="hidden" value="<%=nextPath %>"/> --%>
			<div class="form-group">
				<label for="pw">비밀번호 : </label> <input type="password"
					class="form-control" id="pw" placeholder="Enter password"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20이내의 글자 입력" name="pw" />
			</div>
			<button type="submit" class="btn btn-default" id="confirm">Confirm</button>
		</form>
		<div class="pwCheckResult"></div>
		<hr/>
		<a href="view.do"><button class="btn btn-default">Cancel</button></a>
	</div>
<script type="text/javascript">
$(function(){
	$("#confirm").on("click", function(event){
		event.preventDefault();
		var pw = $("#pw").val().trim();
		$("#pw").val(pw);
		if(pw.length == 0){
			$(".pwCheckResult").html("비밀번호를 입력하세요.");
		} else if(pw.length < 4 || pw.length > 20){
			$(".pwCheckResult").html("비밀번호는 4자이상 20자이내로 작성해주세요.");
		} else {
			$(".pwCheckResult").load("/ajax/checkPw.do", {pw: pw}, function(data, status, jqXGR) {  // callback function 
				if(data.indexOf("틀립니다.") != -1){
					$("#pw").focus();
					return false;
				} else {
					$("#checkPwForm").submit();
				}
			});
		}
	});
	
});
	
</script>

</body>
</html>