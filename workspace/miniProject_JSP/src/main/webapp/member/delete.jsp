<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
    
<%
	//데이터 
	String id = (String)session.getAttribute("memId");
	
	//세션 
	//session.removeAttribute("memName");
	//session.removeAttribute("memId");
	
	session.invalidate(); //무효화 // 모든 세션을 없애버리기 (모든 정보 삭제) 



	// DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	memberDAO.memberDelete(id); //값을 true or false 로 받아올 때는 보통 함수 이름 앞에 is를 붙인다. 
	
    
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
	alert("회원탈퇴 완료!!");
	location.href = "loginForm.jsp";
}
</script>

</body>
</html>