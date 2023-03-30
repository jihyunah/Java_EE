<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #boardView div {
   color: red;
   font-size: 8pt;
   font-weight: bold;
   }
</style>
</head>
<body>
   <form id="boardViewForm" method="post">
      <input type="text" id="seq" value="${requestScope.seq}">
      <input type="text" id="seq" value="${requestScope.pg}">
      <h3>
         작성한 글확인
      </h3>
      <table width="450" border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
         <tr>
            <td colspan="3">
               <h2><span id="subjectSpan"></span></h2>
            </td>
         </tr>
         
         <tr>
            <td width="150" align="center">글번호 : <span id="seqSpan"></span></td>
            <td width="150" align="center">작성자 : <span id="idSpan"></span></td>
            <td width="150" align="center">조회수 : <span id="hitSpan"></span></td>
            
         </tr>
         
         <tr>
            <td colspan="3" height="200" valign="top">
               <div style="width: 100%; height: 100%; overflow: auto;">
                  <pre style="white-space: pre-line; word-break: break-all;">
                     <span id="contentSpan"></span>
                  </pre>
               </div>
            </td>
         </tr>
      </table> 
      <input type="button" value="목록" 
      onclick="location.href='/miniProject_jQuery/board/boardList.do?pg=${pg}'">
      
      <span>
         <input type="button" value="글수정">
         <input type="button" value="글삭제">
      </span>
</form>

<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/boardView.js"></script>
</body>
</html>