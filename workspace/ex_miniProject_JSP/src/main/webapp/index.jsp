<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<h2>*** 메인화면 *** </h2>
<h3>

<a href="">링크 </a><br>

<% if(session.getAttribute("memId") == null ) {%>
	<a href="./member/writeForm.jsp">회원가입 </a><br>
	<a href="./member/loginForm.jsp">로그인 </a><br>
<%} else { %>
	<a href="./member/logout.jsp">로그아웃 </a><br>
	<a href="./member/updateForm.jsp">회원정보수정 </a><br>
	<a href="./member/deleteForm.jsp">회원탈퇴 </a><br>
	<a href="./board/boardWriteForm.jsp">글쓰기 </a><br>
<%} %>
<a href="./board/boardList.jsp?pg=1">목록 </a><br>
</h3>
</div>
</body>
</html>