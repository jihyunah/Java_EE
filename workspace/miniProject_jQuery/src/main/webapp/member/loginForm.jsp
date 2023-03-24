<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form[name="loginForm"] div {
   color: red;
   font-size: 8pt;
   font-weight: bold;
}
</style>
</head>
<body>
<h3>
로그인
</h3>
<form name="loginForm" id="loginForm">
      <table border="1" cellpadding="5" cellspacing="0">
         <tr>
            <th>아이디</th>
            <td><input type="text" name="id" id="id">
               <div id="idDiv"></div></td>
         </tr>

         <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pwd" id="pwd">
               <div id="pwdDiv"></div></td>
         </tr>

         <tr>
            <td colspan="2" align="center">
               <input type="button" value="로그인" id="loginBtn"> 
               <input type="button" value="회원가입" onclick="location.href='miniProject_jQuery/member/writeForm.do'">
            </td>
         </tr>
      </table>
     	<br><br>
     	
     	<div id="loginResult"></div>
   </form>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script> <!-- 이때부터 jQuery 쓸 수 있음. -->
<script type="text/javascript">
$('#loginBtn').click(function(){
	alert('dafsda')
}); /* 딸라 함수 */

</script>
</body>
</html>




<%-- ------------------------------------------------------------------- --%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form[name="loginForm"] div {
   color: red;
   font-size: 8pt;
   font-weight: bold;
}
</style>
</head>
<body>
<h3>
로그인
</h3>
<form name="loginForm" method="post" action="/miniProject_jQuery/member/login.do">
      <table border="1" cellpadding="5" cellspacing="0">
         <tr>
            <th>아이디</th>
            <td><input type="text" name="id" id="id">
               <div id="idDiv"></div></td>
         </tr>

         <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pwd" id="pwd">
               <div id="pwdDiv"></div></td>
         </tr>

         <tr>
            <td colspan="2" align="center">
               <input type="button" value="로그인" onclick="checkLogin()"> 
               <input type="button" value="회원가입" onclick="location.href='miniProject_jQuery/member/writeForm.do'">
            </td>
         </tr>
      </table>
   </form>
<script type="text/javascript">
   function checkLogin(){
      document.getElementById("idDiv").innerText="";
      document.getElementById("pwdDiv").innerText="";
      
      if(document.getElementById("id").value == "") 
         document.getElementById("idDiv").innerText = "아이디를 입력하세요";
      else if(document.getElementById("pwd").value == "") 
         document.getElementById("pwdDiv").innerText = "비밀번호 입력";
      else document.loginForm.submit();
   }
   </script>
</body>
</html> --%>