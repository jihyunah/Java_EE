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
결과 = ${requestScope.list } <br><br>
세번째 항목 = ${requestScope.list[2] } <br><br>

결과 = ${requestScope.list2 } <br><br>

<%-- for(PersonDTO personDTO : list2){} --%>

<c:forEach var="personDTO" items="${requestScope.list2 }">
	이름 = ${personDTO.getName() } &emsp; 나이 = ${personDTO.getAge() }<br>
</c:forEach>



</body>
</html>

















