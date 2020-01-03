<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 수정 폼</title>
<script type="text/javascript" src="/js/regExUtil.js"></script>
<script type="text/javascript">
$(function() {
	$("#writeForm").submit(function() {
		if(!inputDataCheck(title_RegEx, "#title", title_err_msg))
			return false;
		if(!inputDataCheck(content_RegEx, "#content", content_err_msg))
			return false;
		if(!inputDataCheck(startDate_RegEx, "#startDate", startDate_err_msg))
			return false;
		if(!inputDataCheck(endDate_RegEx, "#endDate", endDate_err_msg))
			return false;
	});
});
</script>
</head>
<body>
<h1>공지 수정 폼</h1>
<form action="update.do" method="post" id="writeForm">
	<input type="hidden" name="page" value="${param.page }"> 
	<input type="hidden" name="perPageNum" value="${param.perPageNum }"> 
	<input type="hidden" name="key" value="${param.key}"> 
	<input type="hidden" name="word" value="${param.word }"> 
	<div class="form-group">
		<label for="no">번호(수정불가)</label>
		<input type="text" class="form-control" id="no" name="no" value="${dto.no }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" class="form-control" id="title" name="title" 
		title="제목을 4~100 글자 사이로 입력하셔야 합니다." value="${dto.title }">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea class="form-control" rows="5" id="content" name="content">${dto.content }</textarea>
	</div>
	<div class="form-group">
			<label for="startDate">공지시작일</label>
			<input type="date" class="form-control" id="startDate" name="startDate" 
			 value="${dto.startDate }">
		</div>
		<div class="form-group">
			<label for="endDate">공지종료일</label>
			<input type="date" class="form-control" id="endDate" name="endDate"  value="${dto.endDate }">
		</div>
		
		<button>수정</button>
		<button type="reset">다시입력</button>
		<button onclick="history.back()">취소</button>
	</form>
</body>
</html>