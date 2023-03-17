<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="angel" uri="tld" %> <!-- angel 이라는 새로운 태그에 대한 정보를 알려주는것. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자바클래스의 메소드를 이용 </h3> 
<!-- sum 앞에 아무 이름이나 해줘야 sum 함수를 찾아감.  그리고 그 설정한 이름의 태그를 위에서 경로 설정해줘야함. -->
${param['x'] } + ${param['y'] } = ${ angel:sum(param['x'], param['y']) }<br><br>
${param.x } * ${param.y } = ${ angel:mul(param.x, param.y) }<br><br>

</body>
</html>