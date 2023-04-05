<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.subjectA:link{ color: black; text-decoration: none;}
.subjectA:visited{ color: black; text-decoration: none;}
.subjectA:hover{ color: green; text-decoration: underline;}
.subjectA:active{ color: black; text-decoration: none;}
#currentPaging{
	color: red;
	border: 1px solid red;
	padding: 5px 8px;
	margin: 5px;
	cursor: pointer;
}

#paging{
	color: black;
	padding: 5px;
	margin: 5px;
	cursor: pointer;
}

#boardListTable th {
	font-size: 12pt;
}

#boardListTable td {
	font-size: 10pt;
}
</style>
</head>
<body>

<input type="text" id="pg" value="${pg }">
<input type="text" id="memId" value="${memId }">

<table id="boardListTable" border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="400">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>
	
	
		

</table>


</body>
</html>












