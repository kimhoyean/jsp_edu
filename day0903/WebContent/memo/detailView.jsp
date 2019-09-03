<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery-3.4.1.min.js"></script>
<script>

$(function(){
	$("#btn-submit").hide();
	$("#btn-cancle").hide();
	
	$("#btn-edit").click(function(){
		//$("#writer").attr("readonly",false)
		//$("#memo").attr("readonly",false);
		$("#writer").removeAttr("readonly");
		$("#memo").removeAttr("readonly");
		$("#btn-submit").show();
		$("#btn-cancle").show();
		$("#btn-edit").hide();
		$("#btn-delete").hide();
	});
	$("#btn-cancle").click(function(){
		//$("#writer").attr("readonly",false)
		//$("#memo").attr("readonly",false);
		$("#writer").attr("readonly", true);
		$("#memo").attr("readonly", true);
		$("#btn-submit").hide();
		$("#btn-cancle").hide();
		$("#btn-edit").show();
		$("#btn-delete").show();
	});
	$("#btn-list").click(function(){
		//history.go(-1);
		location.href="../../memo/memo.jsp";
	});
	$("#btn-submit").click(function(){
			$("#detain-from").attr("action","/memo_servlet")
			$("#detain-from").attr("method","post");
			$("#detain-form").submit();
	});
});
</script>
</head>
<body>
<form id="detain-form" method="post">
<table border=1>
	
	<tr>
		<td>작성자</td>
		<td>
		<input type="hidden" id="no" name="no" value="${dto.no}">
		<input id="writer" name="writer" type="text" value="${dto.writer}" readonly>
		</td>
	</tr>
	<tr>
		<td>메모</td>
		<td><input id="memo" name="memo" type="text" value="${dto.memo}" readonly>  </td>
	</tr>
	<tr>
		
		<td colspan="2">
			<button id="btn-submit" type="button">수정하기</button>
			<button id="btn-cancle" type="button">취소하기</button>
			<button id="btn-edit" type="button">수정</button>
			<button id="btn-delete" type="button">삭제</button>
			<button id="btn-list" type="button">목록보기</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>