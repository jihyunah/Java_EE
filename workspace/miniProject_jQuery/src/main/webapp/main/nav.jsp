<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- include 될 jsp파일이기 때문에, html, body같은 다른 태그들은 모두 삭제하고, 알맹이만 남는다. 삭제하지 않을 경우 error 발생 가능성 0. --%>

<!-- <div>
	<input type="button" value="로그인" onclick="location.href='/miniProject_jQuery/member/loginForm.do'"><br><br>
	<input type="button" value="회원가입" onclick="location.href='/miniProject_jQuery/member/writeForm.do'"><br><br>
</div> -->


<div>
   <img src="/miniProject_jQuery/image/login.png" onclick="location.href='/miniProject_jQuery/member/loginForm.do'" style="cursor: pointer; width: 200px;"><br><br>
   <input type="button" value="회원가입" onclick="location.href='/miniProject_jQuery/member/writeForm.do'"><br><br>
</div> 

