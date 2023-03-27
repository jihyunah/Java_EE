<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- include 될 파일이기 때문에 html, body 같은 다른 태그들은 모두 삭제하고, 알맹이만 남는다.  -->

<div> <!-- 현재 세션이 없을 때  -->
	<c:if test="${ sessionScope.memId == null }">
		<img src="/exminiProject_jQuery/image/login.png"
				onclick="location.href='/exminiProject_jQuery/member/loginForm.do'"
				style="cursor: pointer; width: 200px;"><br><br>
		<input type="button" value="회원가입"
				onclick="location.href='/exminiProject_jQuery/member/writeForm.do'"><br><br>
	</c:if>
	
	<!-- 현재 세션이 있을 때 -->
	<c:if test="${ memId != null }">
		<h3>"${ memId }"님 로그인 </h3>
		<input type="button" value="로그아웃" id="logoutBtn">
	</c:if>

</div>

<!-- CDN 방식 : 인터넷 사이트를 통해 접근하기에, 다운받아서 굳이 할 필요 없다.  -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">




</script>










