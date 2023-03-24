<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이미 세션에 다 만들어놔서 데이터 다시 받을 필요 없음.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
String name = session.getAttribute("memName"); 예전에 썼던 자바코드. 이걸 아래와 같이 달러로 쓰면 간단해짐.
 --%>
<h3>${sessionScope.memName }님 로그인</h3>
<br>
	<input type="button" value="로그아웃" onclick="location.href='/mvcMember/member/logout.do'">
	<input type="button" value="회원정보수정" onclick="location.href=''">
	<input type="button" value="회원탈퇴" onclick="location.href=''">
</body>
</html>