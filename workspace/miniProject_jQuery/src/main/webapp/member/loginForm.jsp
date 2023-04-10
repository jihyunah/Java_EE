<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form[name="loginForm"] {
   display: flex;
   flex-direction: column;
   align-items: center;
   margin: 0 auto;
   text-align: left;
}
</style>
</head>
<body>
<form name="loginForm" id="loginForm">
	<a href="../index.jsp" style="text-decoration: none;">
		<h1>로그인</h1>
	</a>
<!-- <form name="loginForm" method="post" action="/miniProject_jQuery/member/login.do"> -->
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
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$('#loginBtn').click(function(){
   $('#idDiv').empty(); //div영역을 초기화
   $('#pwdDiv').empty(); //div영역을 초기화
   
   if( $('#id').val() == '' ) {
      $('#idDiv').text('아이디를 입력');
      $('#id').focus();
   }
   else if( $('#pwd').val() == '' ){
      $('#pwdDiv').text('비밀번호를 입력');
      $('#pwd').focus();
   }
   else {
      $.ajax({ //jQuery.ajax 서버 요청 
         type: 'post', //'get' or 'post'
         url: '/miniProject_jQuery/member/login.do', //보내주는 주소 
         data: 'id=' + $('#id').val() + '&pwd=' + $('#pwd').val(),//서버로 보낼 데이터(id, pwd)
         dataType: 'text',//서버로부터 받는 자료형, text, xml, html, json
         success: function(data){ //보통 data라고 쓴다. 그렇지만 어떤 이름을 집어 넣어도 된다.
            data = data.trim(); //공백 제거 
            
            if(data == 'ok'){
            	location.href='../index.jsp';
            }else if(data =='fail'){
            	$('#loginResult').text('아이디 또는 비밀번호가 맞지 않습니다.');
            	$('#loginResult').css('font-size', '12pt');
            	
            }
         },
         error: function(err){ //404, 505, 500 error가 나오면, 콘솔에 error가 나왔다고 뜬다. 
            colsole.log(err);
         }
      });
   }
   
});   /* jquery문으로 #은 아이디 .은 클래스 */


</script>
</body>
</html>