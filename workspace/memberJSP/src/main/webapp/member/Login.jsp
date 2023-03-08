<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();	//클래스 생성
	String name = memberDAO.memberLogin(id, pwd);
			
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(name == null) { 
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
	
}else {
	
	/*
	//쿠키
	Cookie cookie = new Cookie("memName", name);
	cookie.setMaxAge(30 * 60);	//기본 단위가 초 단위. 3초.
	response.addCookie(cookie);//클라이언트에 보내기
	
	Cookie cookie2 = new Cookie("memId", id);
	cookie2.setMaxAge(30 * 60);	//기본 단위가 초 단위. 30 * 60초.
	response.addCookie(cookie2);//클라이언트에 보내기
	*/
	
	//세션
	//HttpSession session = request.getSession(); // - JSP는 세션이 내장객체로 이미 생성되어있음.
	session.setAttribute("memName", name);
	session.setAttribute("memId", id);
	
	
	//페이지 이동
	response.sendRedirect("loginOk.jsp");
} %>
</body>
</html>