<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="elInputForm" method="get" action="elResult.jsp">
<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<th width="70" align="center">X</th>
		<td>
			<input type="text" name="x" placeholder="x값을 입력하세요">
		</td>
	</tr>
	<tr>
		<th align="center">Y</th>
		<td>
			<input type="text" name="y" placeholder="y값을 입력하세요">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="계산">
			<input type="reset" value="취소 ">
		</td>
	</tr>
	

</table>
</form>

</body>
</html>