<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- include 될 jsp파일이기 때문에, html, body같은 다른 태그들은 모두 삭제하고, 알맹이만 남는다. 삭제하지 않을 경우 error 발생 가능성 0. --%>

<!-- <div>
	<input type="button" value="로그인" onclick="location.href='/miniProject_jQuery/member/loginForm.do'"><br><br>
	<input type="button" value="회원가입" onclick="location.href='/miniProject_jQuery/member/writeForm.do'"><br><br>
</div> -->


<div>
	<c:if test="${sessionScope.memId == null }">
	<img src="/miniProject_jQuery/image/login.png" onclick="location.href='/miniProject_jQuery/member/loginForm.do'" style="cursor: pointer; width: 200px;"><br><br>
	<input type="button" value="회원가입" onclick="location.href='/miniProject_jQuery/member/writeForm.do'"><br><br>

	</c:if>
	
	<c:if test="${memId != null }">
		<h3>"${memId }"님 로그인</h3>
		<input type="button" value="로그아웃" id="logoutBtn">
	</c:if>
</div> 


<!-- CDN 방식 : 인터넷 사이트를 통해 접근하기에, 다운받아서 굳이 할 필요 없다. -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">

$('#logoutBtn').click(function(){
	//서버 요청 - ajax와 연결. 
	$.ajax({
		type:'post',
		url: '/miniProject_jQuery/member/logout.do',
		success: function(){
			alert("로그아웃");
			//location.href='/miniProject_jQuery/index.jsp';
			location.href='./index.jsp'; //현재 위치가 index다. 
		},
		error: function(err){
			console.log(err);
		}
	});
});


</script>










