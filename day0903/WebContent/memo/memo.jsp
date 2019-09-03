<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js" ></script>
<script>
function list(){
	$.ajax({
			url:"memo_servlet/list.mo",
			type: "POST",
			success:function(result){
				$("#result").html(result);
			}});
}
function insert(){
	var writer=$("#writer").val();
	var memo=$("#memo").val();
	var param="writer="+writer+"&memo="+memo;
	$.ajax({
		url:"memo_servlet/insert.mo",
		type:"POST",
		data: param,
		success:function(result){
			list();
			$("#writer").val("");
			$("#memo").val("");
		}
	});
}

$(function(){
	$("#reg_memo").hide();
	$("#btn_memo").show();
	list();
	$("#btn_reg_memo").click(function(){
		
		insert();
	}); 
	$("#btn_memo").click(function(){
		
		$("#reg_memo").show();
		$("#btn_memo").hide();
	}); 	
});
</script>
</head>
<body>
안             녕
<div id="reg_memo">
	작성자: <input type="text" id="writer" name="writer" value="${logName}" required>
	메모 : <input type="text" id="memo" name="memo" required>
	<button id="btn_reg_memo" type="button">메모등록</button>
</div>
<button id="btn_memo" type="button">메모쓰기</button>



<div id="result">
	<!-- 메모장 출력영역 -->
</div>
</body>
</html>