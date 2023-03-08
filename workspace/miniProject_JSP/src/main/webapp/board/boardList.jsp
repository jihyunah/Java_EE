<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>


<%
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> list = boardDAO.boardList();
	

	//페이징 처리 
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	int endNum = pg*5;
	int startNum = endNum-4;
	
	
	//전체 글 개수
	int totalCount = boardDAO.getTotalCount();
	
	/* int totalP = ( totalCount + 4 ) / 5; */
	// 마지막 페이지 번호
	int lastPage = (int)Math.ceil((double)totalCount / 5);
	

%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css" >
.subjectA:link { color: black; text-decoration: none;}
.subjectA:visited{color: black; text-decoration: none;}
.subjectA:hover{color: green; text-decoration: underline;}
.subjectA:active{color: black; text-decoration: none;} 

#currentPagingDiv {float: left; border: 1px red solid; color: red; width: 20px; height: 20px; margin-left: 5px; text-align:center;}
#pagingDiv {float: left; border: 1px black solid; color: black; width: 20px; height: 20px; margin-left: 5px; text-align:center;}
#currentPaging {color: red; text-decoration: none;}
#paging { color: black; text-decoration: none;}

 <!--/* .은 클래스 속성 중에서 라는 뜻 */ -->
</style>
</head>
<body>

<%for(int i = 1; i<=lastPage; i++) {%>
	<%if(i==pg){%>
    <div id='currentPagingDiv'><a id='currentPaging' href='boardList.jsp?pg=<%= i %>'><%=i%></a></div>
	<%} else {%>
    <div id='pagingDiv'><a id='paging' href='boardList.jsp?pg=<%= i %>'><%=i%></a></div>
	<%}%>
	
	<br><br>
<table border='1' cellpadding='5' cellspacing='0' frame="hsides" rules="rows">
	<tr>
		<th width='150'>글번호 </th>
		<th width='300'>제목 </th>
		<th width='150'>이름 </th>
		<th width='100'>조회수 </th>
		<th width='150'>작성일 </th>
	</tr>
		<% if (list != null) { %>
  		  <% for (BoardDTO boardDTO : list) { %>
       		 <tr>
          	  <td align="center"><%=boardDTO.getSeq() %></td>
          	  <td><a class="subjectA" href=""><%=boardDTO.getSubject() %></a></td>
          	  <td align="center"><%=boardDTO.getId() %></td>
           	 <td align="center"><%=boardDTO.getHit() %></td>
           	 <td align="center"><%= new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime())%></td>
       		 </tr>
   <% } %>
<% } %>


	</table>
<h3>
<img src="../image/1.png" width="40" height="40" alt="찰칵" 
onclick="location.href='../index.jsp'" style="cursor:pointer">
</h3>

</body>
</html>