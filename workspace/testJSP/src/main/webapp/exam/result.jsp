<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//데이터 
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));

%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
<!-- 2. 응답 -->
<%= x %> + <%=y %> = <%=x+y %><br>
<%= x %> - <%=y %> = <%=x-y %><br>
<%= x %> * <%=y %> = <%=x*y %><br>
<%= x %> / <%=y %> = <%=(double)x/y %><br>
</h3>






</body>
</html>