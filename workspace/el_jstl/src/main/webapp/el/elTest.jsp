<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="50%">
	<tr>
		<th width="50%">표현식</th>
		<th>값</th>
	</tr>
	
	<tr>
		<td align="center">\${25+3 }</td> <!-- 앞에 역슬래쉬 \ 붙으면 있는 모양 그대로 출력. -->
		<td align="center">${25+3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25/3 }</td>
		<td align="center">${25/3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25 div 3 }</td>
		<td align="center">${25 div 3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25%3 }</td>
		<td align="center">${25%3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25 mod 3 }</td>
		<td align="center">${25 mod 3 }</td> <!-- mod=나머지 구하기. -->
	</tr>
	
	<tr>
		<td align="center">/${25 < 3 }</td>
		<td align="center">${25 < 3 }</td>
	</tr>
	
	<!-- > gt, < lt, >= ge, <= le, == eq, != ne -->
	
	<tr>
		<td align="center">\${25 ne 3 }</td>
		<td align="center">${25 ne 3 }</td>
	</tr>
	
	<tr> <!-- 현재 서버가 누구인지 알 수 있다.  -->
		<td align="center">\${header['host'] }</td>
		<td align="center">${header['host'] }</td>
	</tr>
	
	<tr> <!-- 위와 같음.  -->
		<td align="center">\${header.host }</td>
		<td align="center">${header.host }</td>
	</tr>
</table>

</body>
</html>