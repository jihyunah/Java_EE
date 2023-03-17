<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터 
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	
	/* request.getParameter("x") 대신 이제부턴 param['x']이라고 쓴다. (el) */

%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${param['x'] } + ${param['y'] } = ${param['x'] + param['y'] }<br><br>
${param['x'] } - ${param['y'] } = ${param['x'] - param['y'] }<br><br>
${param.x } * ${param.y} = ${param.x * param.y }<br><br>
${param.x } / ${param.y } = ${param.x / param.y }<br><br>

</body>
</html>