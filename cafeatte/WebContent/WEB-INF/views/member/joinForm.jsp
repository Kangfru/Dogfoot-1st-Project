<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap 라이브러리 등록 : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$("#id").on("keyup", function(){
		var id = $("#id").val().trim();
		$("#id").val(id);
		if(id.length == 0){
			$("#idCheck").html("아이디를 입력하세요.");
		} else if(id.length < 4 || id.length > 20){
			$("#idCheck").html("아이디는 4자이상 20자이내로 작성해주세요.");
		} else {
			// 적당한 아이디를 입력한 경우 ajax를 이용해 서-버에서 아이디 확인
			$("#idCheck").load("/ajax/idCheck.do?id=" + id);
		}
	}); // 아이디 중복체크 끝
	
	// 데이터를 넘기기 전 데이터 확인 처리 이벤트
	$("#joinForm").on("submit", function(){
		if($("#idCheck").text().indexOf("사용 가능한") <= -1){
			alert("사용가능한 아이디를 입력해주세요!");
			$("#id").focus();
			return false;
		}
		if($("#pw").val() != $("#pw2").val()){
			alert("비밀번호 확인이 일치하지 않습니다.");
			$("#pw").focus();
			return false;
		}
	});
});
</script>

<script>
	$(function() {
		$("#birth").datepicker({
			changeMonth : true,
			changeYear : true
		});
		$("#birth").datepicker("option", "dateFormat", "yy-mm-dd");
	});
</script>
<title>회원가입</title>
</head>

<body>
	<div class="container">
		<!-- header tag -> h1 : 첫번째 나오는 제목이 제일 크므로 1~6 순으로 크기가 큼 / 자동 줄 바꿈이 됨 -->
		<h2>회원가입</h2>
		<form action="join.do" method="post" id="joinForm" enctype="multipart/form-data">
			<!-- 			아이디입력 -->
			<div class="form-group">
				<!-- id 4자~20자 -->
				<!-- max length : 최대 입력 글자수, pattern : 입력 글자의 형식, title : 마우스를 올려두거나 또는 형식에 안맞을 때 뜨는 메세지-->
				<label for="ID">아이디 : </label> <input type="text"
					class="form-control" id="id" placeholder="Enter ID" maxlength="20"
					required="required" pattern="^[A-Za-z][A-za-z0-9]{3,19}$"
					title="4-20영숫자, 맨 앞자는 영문자" name="id" autocomplete="off"/>
					<div id ="idCheck">아이디를 입력하세요.</div>
			</div>
			<!-- 			비밀번호 입력 -->
			<div class="form-group">
				<label for="pw">비밀번호 : </label> <input type="password"
					class="form-control" id="pw" placeholder="Enter password"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20이내의 글자 입력" name="pw" />
			</div>
			<!-- 			비밀번호 확인 입력 -->
			<div class="form-group">
				<label for="pw2">비밀번호확인 : </label> <input type="password"
					class="form-control" id="pw2" placeholder="비밀번호 확인" maxlength="20"
					required="required" pattern="^.{4,20}$" title="4-20이내의 글자 입력"
					name="pw2" />
			</div>
			<div id="checkPwResult"></div>
			<!-- 			이름 입력 -->
			<div class="form-group">
				<!-- 이름 2자~10자, 한글만 가능, 필수입력 -->
				<label for="name">닉네임 : </label> <input type="text"
					class="form-control" id="nickName" placeholder="닉네임을 입력하세요."
					maxlength="10" required="required" pattern="^.{2,10}$"
					title="2-10 한글" name="nickName" />
			</div>
			<div class="form-group">
				<!-- 이름 2자~10자, 한글만 가능, 필수입력 -->
				<label for="addr">주소 : </label> <input type="text"
					class="form-control" id="addr" placeholder="주소을 입력하세요."
					maxlength="50" required="required" pattern="^.{2,50}$"
					name="addr" />
			</div>
			<!-- 			이메일 입력란 -->
			<div class="form-group">
				<!-- id 4자~20자 -->
				<!-- max length : 최대 입력 글자수, pattern : 입력 글자의 형식, title : 마우스를 올려두거나 또는 형식에 안맞을 때 뜨는 메세지-->
				<!-- 				type을 email로 쓰면 이메일 형식에 맞는지도 검사한다. -->
				<label for="email">email : </label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					maxlength="100" required="required"
					pattern="^[a-zA-Z0-9._%+_]*@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$"
					title="example) exam@exam.com" name="email" />
			</div>
			<div class="form-group">
				<!-- id 4자~20자 -->
				<!-- max length : 최대 입력 글자수, pattern : 입력 글자의 형식, title : 마우스를 올려두거나 또는 형식에 안맞을 때 뜨는 메세지-->
				<!-- 				type을 email로 쓰면 이메일 형식에 맞는지도 검사한다. -->
				<label for="question">비밀번호 찾기 질문 : </label> <input type="text"
					class="form-control" id="question" placeholder="예) 졸업한 초등학교의 이름은?"
					maxlength="100" required="required"
					title="비밀번호 찾기 질문" name="question" />
			</div>
			<div class="form-group">
				<label for="answer">비밀번호 찾기 답변 : </label> <input type="text"
					class="form-control" id="answer" placeholder="예) 어때초등학교"
					maxlength="100" required="required"
					title="비밀번호 찾기 답변" name="answer" />
			</div>
			<!-- 			전화번호 입력란 -->
			<div class="form-group row">
				<div class=col-md-2>
					<label for="tel">전화번호 : </label>
				</div>
				<div class="col-md-2">
					<select class="form-control" id="tel" name="tel">
						<option>010</option>
						<option>011</option>
						<option>016</option>
						<option>017</option>
						<option>018</option>
						<option>019</option>
					</select>
				</div>
				<div class="col-md-2">
					<input type="number" class="form-control" id="tel2"
						placeholder="3~4자리" maxlength="4" pattern="\d{3,4}$"
						 name="tel" />
				</div>
				<div class="col-md-2">
					<input type="number" class="form-control" id="tel3"
						placeholder="4자리" maxlength="4" pattern="\d{4}$"
					 	name="tel" />
				</div>
			</div>
			<div class="form-group">
				<label for="multiFile">이미지 첨부</label> 
				<input type="file" name="photo" class="form-control" id="photo"><br/>
			</div>

			<!-- 버튼의 기본 타입은 submit -->
			<button class="btn btn-default">Join</button>
		</form>
	</div>
	<script type="text/javascript">
		const pw = document.querySelector("#pw");
		const pw2 = document.querySelector("#pw2");
		const checkPwResult = document.querySelector("#checkPwResult");
		function checkPw(){
			if(pw.value === pw2.value){
				checkPwResult.innerHTML = "<span style='color: blue;'>비밀번호가 일치합니다.</span>";
			} else {
				checkPwResult.innerHTML = "<span style='color: red;'>비밀번호가 일치하지 않습니다.</span>";
			}
		}
		
		pw2.addEventListener("keyup", checkPw);
		
	</script>
</body>
</html>