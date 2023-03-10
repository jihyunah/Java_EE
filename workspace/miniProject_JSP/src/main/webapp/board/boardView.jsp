<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>

    
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
<h3>
<img src="../image/1.png" width="50" height="50" alt="찰칵" 
onclick="location.href='../index.jsp'" style="cursor:pointer";>작성한 글 확인 
</h3>
<form name="boardWriteForm" method="post" action="">

		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" id="subject" size="50" value="<%=boardDTO.getSubject() %>">
					<div id="subjectDiv"></div>
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" id="content" cols="50" rows="15"><%=boardDTO.getContent()%></textarea>
					<div id="contentDiv"></div>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="목록" onclick="">
				</td>
			</tr>
			
		</table>
</form>




<%} %>

</body>
</html>