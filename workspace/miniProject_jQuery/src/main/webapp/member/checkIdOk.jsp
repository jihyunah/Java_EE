<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${requestScope.id }는 사용 가능</h3>
<input type="button" value="사용하기" onclick="checkIdClose('${param.id }')">

<script type="text/javascript">

function checkIdClose(id){
	opener.writeForm.id.value = id //id값을 id 칸에 넣겠다. 
	opener.writeForm.check.value = id // 중복체크 버튼을 눌렀다는 확인
	window.close()
	opener.writeForm.pwd.focus()
}

</script>

</body>
</html>