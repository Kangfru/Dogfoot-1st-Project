<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 글보기</title>

<style type="text/css">
	.modal-header, .modal-header h4, .close{
		background: black;
		color: white;
		font-size: 30px;
	}
</style>

<script type="text/javascript">
	$(function() {
		$("#deleteBt").click(function() {
			if (!confirm("정말 삭제하시겠습니까?"))
				return false;
		});

// 		$("#writeBtn").click(function(){
// 			$(".modal-header > h4").html("<span class='glyphicon glyphicon-pencil'></span> 댓글 쓰기");
			
// 			$("#modal_content").val("");
// 			$("#modal_writer").val("");
			
// 			$("#updateModal_updateBtn").text("등록");

// 			$("#modal_writer").attr("disabled", false);
			
// 			$("#modal_form").attr("action", "replyWrite.do")
			
// 			$("#updateModal").modal();
// 		});
		
		$(".updateBts").click(function() {
			var row = $(this).closest(".dataRow");
// 			alert(row);
			var rno = row.data("rno");
// 			alert(rno);
			var content = row.find(".content").text();
// 			alert(content);
			
// 			$("#modal_rno").val(rno);
// 			$("#modal_content").val(content);
			
// 			$("#modal_content").val("");
// 			$(".updateModal").modal();
		});
	});
	
	
</script>
</head>
<body>
	<h1>공지 글보기</h1>
	<table class="table">
		<tr>
			<th>공지 번호</th>
			<td>${dto.no }</td>
		</tr>
		<tr>
			<th>공지 제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>공지 내용</th>
			<td>${dto.content }</td>
		</tr>
		<tr>
			<th>공지 시작일</th>
			<td>${dto.startDate }</td>
		</tr>
		<tr>
			<th>공지 종료일</th>
			<td>${dto.endDate }</td>
		</tr>
		<tr>
			<th>공지 등록일</th>
			<td>${dto.writeDate }</td>
		</tr>
		<tr>
			<td colspan="2"><a
				href="updateForm.do?no=${dto.no }&page=${param.page }&perPageNum=${param.perPageNum}
			&key=${param.key}&word=${param.word}"><button>수정</button></a>
				<a href="delete.do?no=${dto.no }&perPageNum=${param.perPageNum }"
				id="deleteBt"><button>삭제</button></a> 
				<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum}
			&key=${param.key}&word=${param.word}"><button>목록</button></a>
			</td>
		</tr>
	</table>
</body>
</html>