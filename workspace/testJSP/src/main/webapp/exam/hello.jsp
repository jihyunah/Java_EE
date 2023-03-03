<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  위에 두줄은 선언문. 
    *directive 선언
     -->
     
<%! 
// 선언문 - 전역(필드) - 1번만 실행됨. 
	String name = "홍길동";
	int age = 25;
%>

<%
//선언문 스크립트릿 - 지역, 호출시마다 실행.--> 새로고침 할 때마다. 
age++;

%>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  Hello JSP!!<br> -->
<%-- 안녕하세요 JSP!!<br> --%> 
나의 이름은 <%=name %> 입니다<br>
<% out.println("나의 이름은 " + name + "입니다."); %>
<%-- jsp에서는 out 객체가 원래 있기에 바로 쓸 수 있음. 그런데 out 말고 <%= ... %> 를 쓰자. --%>
<!--  내 나이는 <%=age %> 입니다<br> -->
<%-- 내 나이는 <%=age %> 입니다<br> --%>







</body>
</html>