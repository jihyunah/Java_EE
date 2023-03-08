<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%
	//데이터 
	request.setCharacterEncoding("UTF-8");

	String subject = request.getParameter("subject"); //boardWriteForm에서 받아옴. 
	String content = request.getParameter("content");
	
	
	//세션 
	//HttpSession //session = request.getSession(); //이거 안해도 jsp파일은 session이 내장객체로 있다. 
	String id = (String)session.getAttribute("memId");
	String name = (String)session.getAttribute("memName");
	String email = (String)session.getAttribute("memEmail");
	
	//위 5개 데이터 묶음처리 -> Map 사용하기 
	Map<String, String> map = new HashMap<String, String>();
	map.put("id", id); //"id"가 이름, id가 값. 
	map.put("name", name);
	map.put("email", email);
	map.put("subject", subject);
	map.put("content", content);
	
	//값 꺼낼땐 map.get("id");
	
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.boardWrite(map);
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
window.onload=function(){
	alert("글작성 완료 ");
	location.href = "../index.jsp?pg=1";
}

</script>

</body>
</html>