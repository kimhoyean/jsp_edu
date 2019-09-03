<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인, 게시판, 메모장</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script >


</script>
</head>
<body>

    <header>
        <section id="header-bar">
            <div class="flex-container ">
                <h2 id="logo">global-logo</h2>
                <div>
                <c:if test="${empty(logName) }">
	                <form id="login-form" action="member/login.me" method="post">
	                    <input type="text" name="id" placeholder="아이디">
	                    <input type="password" name="pass" placeholder="비밀번호">
	                    <button type="submit" >로그인</button>
	                </form>
                </c:if>
                <c:if test="${not empty(logName) }">
                	<form action="member/logout.me" method="post">
                	<span>${logName }님 환영합니다.</span>
                	<button id="btnLogout" type="submit">로그아웃</button>
                	</form>
                </c:if>
                </div>
            </div>
            <div id="links" >
                <div>
                <a href="#">아이디</a>·
                <a href="#">비빌번호 찾기</a>
                <a href="./member/registration.jsp">회원가입</a>
                </div>
            </div>
           
        </section>
        <nav id="top-menu">
            <ul class="flex-container ">
                <li>메 뉴1</li>
                <li>메 뉴2</li>
                <li>메 뉴3가 길어?</li>
                <li>메 뉴4</li>
                <li><a href="memo/memo.jsp">메모장</a></li>
            </ul>
        </nav>
    </header>
    <main>
        메인콘덴츠영역<br>
        

    </main>
    <footer>
        하단영역
    </footer>
</body>
</html>