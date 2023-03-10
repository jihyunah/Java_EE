<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.dao.BoardDAO"%>

    
<%
	//데이터
	String id = request.getParameter("id");

	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	boolean existId = memberDAO.isExistId(id); //id가 있다/true/사용불가능 
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(existId) {%>
	<form action="checkId.jsp">
		<h3><%=id %>는 사용 불가능 </h3>
		아이디 <input type="text" name="id"> <input type="submit" value="중복체크">
	</form>
<%} else{ %>
	<h3><%=id %>는 사용 가능 </h3>
	<input type="button" value="사용하기" onclick="checkIdClose('<%=id %>')">
<%} %>


<script type="text/javascript">
function checkIdClose(id){
	//opener 은 열려있는 모든 창들 중 id 이름을 가진 아이를 말함. 
	opener.writeForm.id.value = id
	window.close()
	opener.writeForm.pwd.focus()
	
}
</script>
</body>
</html>