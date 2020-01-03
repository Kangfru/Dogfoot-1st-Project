<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정하기</title>

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
			<img src="${dto.photo }" class="img-circle" width="60%" />
			<p>프로필 사진</p>
		</div>
		<div class="right">
			<form action="update.do" method="post" id="updateForm"
				enctype="multipart/form-data">
				<input type="hidden" name="photo" value="${dto.photo }" />
				<table class="table">
					<tr class="form-group">
						<td>아이디</td>
						<td><input type="text" name="id" value="${dto.id }"
							style="background: gray;" readonly /></td>
					</tr>
					<tr class="form-group">
						<td>닉네임</td>
						<td><input type="text" name="nickName"
							value="${dto.nickName }" style="background: gray;" readonly /></td>
					</tr>
					<tr class="form-group">
						<td>주소</td>
						<td><input type="text" name="addr" value="${dto.addr }" /></td>
					</tr>
					<tr class="form-group">
						<td>이메일</td>
						<td><input type="text" name="email" value="${dto.email }" /></td>
					</tr>
					<tr class="form-group">
						<td>전화번호</td>
						<td><input type="text" name="tel" value="${dto.tel }" /></td>
					</tr>
				</table>
				<div class="form-group">
					<label for="multiFile">프로필 사진 변경</label> <input type="file"
						name="upPhoto" class="form-control" id="upPhoto"><br />
				</div>
				<button class="btn btn-default">수정하기</button>
				<button class="btn btn-default" id="cancleBtn">취소하기</button>
			</form>
			<a href="changePwForm.do"><button class="btn btn-default">비밀번호
					수정</button></a>
			<button class="btn btn-default sign_out_btn">탈퇴하기</button>

		</div>
	</div>
	<div class="modal hidden">
		<div class="modal__overlay"></div>
		<div class="modal__content">
			<h1>정말 탈퇴 하시겠습니까?</h1>
			<p>그 동안의 모든 혜택(쿠폰)을 더 이상 이용하실 수 없으며 동일한 아이디로 재 가입이 불가능합니다.</p>
			<button class="modalAccept">예</button>
			<button class="modalClose">취소</button>
		</div>
	</div>
	<script type="text/javascript">
		const signOutBtn = document.querySelector(".sign_out_btn");
		const modal = document.querySelector(".modal");
		const overlay = modal.querySelector(".modal__overlay");
		const modalAccept = modal.querySelector(".modalAccept");
		const modalClose = modal.querySelector(".modalClose");

		function handleCancleBtn() {
			const cancleBtn = document.querySelector("#cancleBtn");
			cancleBtn.addEventListener("click", function(event) {
				event.preventDefault();
				location = "view.do";
			});
		}

		function init() {
			handleCancleBtn();
		}
		init();


		function closeModal() {
			modal.classList.add("hidden");
		}

		function openModal() {
			modal.classList.remove("hidden");
		}

		function acceptModal() {
			location.href = "/member/signOut.do?id=${dto.id}";
			closeModal();
		}

		signOutBtn.addEventListener("click", openModal);
		modalClose.addEventListener("click", closeModal);
		modalAccept.addEventListener("click", acceptModal);
	</script>


</body>
</html>