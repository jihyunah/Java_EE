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

결과 = ${requestScope.list } <br> <br>
세번째 항목 = ${ requestScope.list[2] } <br> <br>

결과 = ${requestScope.list2 } <br> <br>

<%-- for(PersonDTO personDTO : list2 ) <br> <br> --%>

<%-- 메소드명을 변수명처럼 사용할 수 있다. --%>
<c:forEach var="personDTO" items="${list2 }"> <!-- var에 데이터를 옮긴다. -->
	이름 = ${personDTO.getName() } &emsp; 나이 = ${personDTO.getAge() } <br>
	이름 = ${personDTO.name} &emsp; 나이 = ${personDTO.age } <br> <%-- name을 의미하는게 아니라, getName()을 말하는것임. --%>
</c:forEach>



</body>
</html>