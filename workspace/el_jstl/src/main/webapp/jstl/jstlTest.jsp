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
<h3>*** 변수 설정 ***</h3>
<c:set var="name" value="홍길동"></c:set>
<c:set var="age">25</c:set>

나의 이름은 <c:out value="${name }"></c:out> 입니다. <br>
내 나이는 ${age }살 입니다.<br>

<h3>** forEach ***</h3>
<c:forEach var="i" begin="1" end="10" step="1">
	${i }&nbsp;&emsp; <!-- &nbsp는 한칸 정도 띄우고, emsp는 4칸정도 띄운다.  -->
	<c:set var="sum" value="${sum + i }">
	</c:set>
</c:forEach>
<br>
1 ~ 10까지의 합 = ${sum }
<br><br>

<c:forEach var="i" begin="1" end="10" step="1">
 ${11-i}&nbsp;
</c:forEach>

<h3>*** forToken ***</h3>

<!-- 문자열 분리
1. StringTokenizer
2. String클래스의 split() -->

<c:forTokens var="car" items="소나타,아우디,링컨,페라리,벤츠" delims=","> <!-- ,로 분리를 하겠다. -->
	${car }<br>
</c:forTokens>








</body>
</html>