<%@ page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.bean.BoardPaging" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.subjectA:link { color: black; text-decoration: none;}
.subjectA:visited { color: black; text-decoration: none;}
td .subjectA:hover { color: green; text-decoration: underline;}
.subjectA:active { color: black; text-decoration: none;}

#currentPaging{
	color: red;
	border: 1px solid red;
	padding: 5px 8px; /* top / bottom, left / right  */
	margin: 5px; /* top, right, bottom, left  */
	cursor: pointer;
}
#paging{
	color: black;
	padding: 5px;
	margin: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
<img src="../image/1.png" width="70" height="70" alt="찰칵" 
onclick="location.href='../index.jsp'" style="cursor: pointer;">
<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>
	
	<c:if test="${list!=null }">
		<c:forEach var="boardDTO" items="${list }">
			<tr>
				<td align="center">${ boardDTO.getSeq()}</td>
				<td><a class="subjectA" href="#" onclick="isLogin('${ memId }', '${ boardDTO.getSubject()}')"></a></td>
				<td align="center">${ boardDTO.getId()}</td>
				<td align="center">${ boardDTO.getHit()}</td>
				<td align="center">
					${ new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime()) }
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<div style="margin-top: 15px; width: 850px; text-align: center;">
	${ boardPaging.getPagingHTML() }
</div>

<script type="text/javascript">
function boardPaging(pg) {
	location.href = "boardList.jsp?pg=" + pg;
}

function isLogin(memId, seq, pg){
	if(memId == 'null') alert("먼저 로그인하세요 ");
	else
		location.href="boardView.jsp?seq=" + seq + "&pg=" + pg;
}
</script>
</body>
</html>




















