<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.4.1.min.js"></script>
<script>
$(function(){
	$("#btn").click(function (){
		alert("브라우저 종료");
		window.close();
	});
});
</script>
</head>

<body>
<button id="btn" type="button">윈도우 닫기</button>
</body>
</html>