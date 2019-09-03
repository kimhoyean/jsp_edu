<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>NO<td>
			<td>메모<td>
			<td>작성자<td>
			<td>날짜<td>
		<tr>
		<c:forEach var="memoDTO"  items="${list }">
		<tr>
			<td>${memoDTO.no }<td>
			<td><a href="memo_servlet/detailView.mo?no=${memoDTO.no }">${memoDTO.memo }</a><td>
			<td>${memoDTO.writer } <td>
			<td>${memoDTO.reg_date }<td>
		<tr>
		</c:forEach>
	</table>
</body>
</html>