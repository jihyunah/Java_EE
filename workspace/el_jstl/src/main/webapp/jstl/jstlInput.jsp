<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="jstlResult.jsp">
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th width="70">이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th width="70">나이</th>
			<td><input type="text" name="age"></td>
		</tr>
		
		<tr>
			<th width="70">색깔</th>
			<td>
				<select name="color" id="color" style="width: 100px;">
					<optgroup label="색깔 ">
						<option value="red">빨강</option>
						<option value="green">초록</option>
						<option value="blue">파랑</option>
						<option value="magenta">보라</option>
						<option value="cyan">하늘</option>
					</optgroup>
				</select>
			</td>
		</tr>
		
		<tr>
	
			<th width="70"> 취미  </th>
			<td>
				<input type="checkbox" name="hobby" value="book" >
				<label for="book">독서 </label>
			
				<input type="checkbox" name="hobby" value="movie">
				<label for="movie">영화 </label>
			
				<input type="checkbox" name="hobby" value="music">
				<label for="music">음악 </label>
			
				<input type="checkbox" name="hobby" value="game">
				<label for="game">게임 </label>
			
				<input type="checkbox" name="hobby" value="shopping">
				<label for="shopping">쇼핑 </label>
			
				<div id="hobbyDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="SEND">
				<input type="reset" value="CANCEL">
			</td>
		</tr>
	</table>
</form>

</body>
</html>