<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<link rel="stylesheet" type="text/css" href="../css/style2.css">
<script src="../js/jquery-3.4.1.min.js"></script>
<script>
$(function(){
	$("#pass2").focusout(function(){
		var pass=$("#pass").val();
		if(pass != $("#pass2").val()){
			$("#pass2-msg").text("*비밀번호가 일치하지 않습니다.");
			$("#pass2").focus();
		}else{
			$("#pass2-msg").text("");
		}
	});
	
});
</script>
</head>
<body>
<div id="reg">
	<h2 id="join-title">회원가입</h2>
	<form id="reg-form" action="regist.me" method="post">
		<p>
			<label for="name">이름</label>
			<input id="name" type="text" name="name" placeholder="이름"  required/>
		</p>
		<p>
			<label for="id">아이디</label>
			<input id="id" type="text" name="id" placeholder="아이디"  required/>
		</p>
		<p>
			<label for="pass">비밀번호</label>
			<input id="pass" type="password" name="pass" placeholder="비밀번호"  required/>
		</p>
		<p>
			<label for="pass2">비밀번호 재확인</label>
			<input id="pass2" type="password" name="pass2" placeholder="비밀번호 재확인"  required/>
			<br><span id=pass2-msg></span>
		</p>
		<p>
			<label for="email">이메일</label>
			<input id="email" type="email" name="email" placeholder="이메일"  required/>
		</p>
		<p id="reg-btn-area">
			<button id="reg-btn" type="submit">회원가입</button>
		</p>
	</form>
</div>
</body>
</html>