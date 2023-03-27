<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>

    
<%
	//데이터 
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDTO boardDTO = boardDAO.getBoard(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#contentDiv {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
#subjectDiv {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<%if(boardDTO != null) {%>
<form name="boardWriteForm" method="post" action="">
	

		<table width="450" border="2" cellpadding="5" cellspacing="0" fram="hsides" rules="rows">
			<tr>
				<td colspan="3">
					<h2> <%=boardDTO.getSubject() %> </h2>
				</td>
			</tr>
			
			<tr>
				<td width="150" align="center">글번호 : <%=boardDTO.getSeq() %></td>
				<td width="150" align="center">작성자 : <%=boardDTO.getId() %></td>
				<td width="150" align="center">조회수 : <%=boardDTO.getHit() %></td>
			</tr>
			
			<tr>
				<td colspan="3" height="250" valign="top">
					<div style="width: 100%; height: 100%; overflow: auto;">
					<!--  white-space: pre-wrap이 자동개행 -->
					<pre style="white-space: pre-line; word-break: break-ali"><%=boardDTO.getContent() %></pre>
					</div>
					</td>
			</tr>
			
			
		</table>
		<input type="button" value="목록" onclick="history.go(-1)">
</form>




<%} %>

</body>
</html>