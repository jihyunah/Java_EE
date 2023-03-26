<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#writeForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form id="writeForm" method="post" action="write.jsp">
 <table border="1" cellpadding="5" cellspacing="0">
  <tr>
  	<th>이름</th>
  	<td>
  	 <input type="text" name="name" id="name" placeholder="이름 입력">
  	 <div id="nameDiv"></div>
  	</td>
  </tr>
  
  <tr>
  	<th>아이디</th>
  	<td>
  	 <input type="text" name="id" id="id" size="30" placeholder="아이디 입력">
  	 
  	 <input type="hidden" id="check" value="">
  	 
  	 <input type="button" value="중복체크" id="checkIdBtn">
  	 
  	 
  	 
  	 <div id="idDiv"></div>
  	</td>
  </tr>
  
  <tr>
  	<th>비밀번호</th>
  	<td>
  	 <input type="password" name="pwd" id="pwd" size="40" >
  	 <div id="pwdDiv"></div>
  	</td>
  </tr>
  
  <tr>
  	<th>재확인</th>
  	<td>
  	 <input type="password" name="rdpwd" id="repwd" size="40" >
  	</td>
  </tr>
  
  <tr>
   <th>성별</th>
    <td>
     <input type="radio" name="gender" id="gender_m" value="0" checked/>
     <label for="gender_m">남자</label>			
     <input type="radio" name="gender" id="gender_f" value="1" />
     <label for="gender_f">여자</label>	
    </td>		
  </tr>
  
  <tr>
   <th>이메일</th>
   <td>
    <input type="text" name="email1" style="width: 120px;">
    @
    <input type="text" name="email2" id="email2" style="width: 120px;">
    <select name="email3" id="email3" style="width: 120px;" onchange="select()">
     <option value="">직접입력</option>
     <option value="naver.com">naver.com</option>
     <option value="gmail.com">gmail.com</option>
     <option value="nate.com">nate.com</option>
    </select>
   </td>
  </tr>
  
  <tr>
   <th>휴대폰</th>
   <td>
    <select name="tel1" style="width: 70px;">
     <option value="010">010</option>
     <option value="011">011</option>
     <option value="019">019</option>
     <option value="070">070</option>
    </select>
    -
    <input type="text" name="tel2" style="width: 70px;">
    -
    <input type="text" name="tel3" style="width: 70px;">
   </td>
  </tr>
  
  <tr>
   <th>주소</th>
   <td>
    <input type="text" name="zipcode" id="zipcode" size="5" placeholder="우편번호" readonly>
    <input type="button" value="우편번호검색" onclick="execDaumPostcode()">
    <br>
    <input type="text" name="addr1" id="addr1" style="width: 400px;" placeholder="주소" readonly/>
    <br>
    <input type="text" name="addr2" id="addr2" style="width: 400px;" placeholder="상세주소" />
   </td>
  </tr>
  
  <tr>
  	<td colspan="2" align="center">
  	 <input type="button" value="회원가입" onclick="checkWrite()">
  	 <input type="reset" value="다시작성">
  	</td>
  </tr>
 </table>
</form>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../js/member.js"></script>



<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">

$('#checkIdBtn').click(function(){
	let status = $('#id').attr('status'); //아이디 중복체크 상태
	let id = $('#id').val(); //입력한 아이디값
	
	$('#idDiv').empty();
	
	if( $('#id').val() == '' ) {
		$('#idDiv').text('먼저 아이디를 입력하세요');
		$('#id').focus();
		return;
	}
	else {
	
	      $.ajax({ //jQuery.ajax 
	         type: 'post', //'get' or 'post'
	         url: '/miniProject_jQuery/member/checkId.do', //보내주는 주소 
	         data: 'id=' + $('#id').val(),//서버로 보낼 데이터(id)
	         dataType: 'text',//서버로부터 받는 자료형, text, xml, html, json
	         success: function(data){ //보통 data라고 쓴다. 그렇지만 어떤 이름을 집어 넣어도 된다.
	        	//기존 아이디가 존재한다면
					if(data.cnt > 0){
						$('#id').attr('status', 'no');
						$('#id').after("<span class='checkIdSpan' style='color:red'>이미 존재하는 아이디입니다.</span>")
						$('#id').focus();
					} //기존 아이디가 존재하지 않으면
					else{
						$('#id').attr('status', 'yes');
						$('#id').after("<span class='checkIdSpan' style='color:blue'>사용 가능한 아이디입니다.</span>")
					}
						
					
		            
		         
		         location.href='../member/checkId.do';
	         },
	        	
	            
	        
	         error: function(err){ //404, 505, 500 error가 나오면, 콘솔에 error가 나왔다고 뜬다. 
	            console.log(err);
	         }
	      });
	   }
	   
	});   /* jquery문으로 #은 아이디 .은 클래스 */





</script>


</body>
</html>




















