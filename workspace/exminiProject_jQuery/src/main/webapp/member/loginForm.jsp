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
               <input type="button" value="회원가입" onclick="location.href='/exminiProject_jQuery/member/writeForm.do'">
            </td>
         </tr>
      </table>
      <br><br>
      
      <div id="loginResult"></div>
      
   </form>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$('#loginBtn').click(function(){
	$('#idDiv').empty(); //초기화 
	$('#pwdDiv').empty(); //초기화 
	
	if($('#id').val() == '') {
		$('#idDiv').text('아이디를 입력');
		$('#id').focus();
	}
	
	else if($('#pwd').val() == '') {
		$('#pwdDiv').text('비밀번호 입력');
		$('#pwd').focus();
	}
	else {
		$.ajax({ //jQuery.ajax 서버 요청 
			type: 'post',
			url: '/exminiProject_jQuery/member/login.do', 
			data: 'id=' + $('#id').val() + '&pwd=' + $('#pwd').val(),
			dataType: 'text',
			success: function(data){
				data = data.trim(); //공백 제거 
				
				if(data == 'ok')
					location.href='../index.jsp';
				else if(data =='fail') {
					$('#loginResult').text('아이디 또는 비밀번호가 맞지 않습니다. ');
					$('#loginResult').css('font-size', '12pt')
				}
			},
			
			error: function(err){
				console.log(err);
			}
		});
	}
});


</script>
</body>
</html>