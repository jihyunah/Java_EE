<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<input type="text" id="seq" value="${seq }">
<input type="text" id="pg" value="${pg }"> 


<form id="boardViewForm" method="post" action="">
	

		<table id="boardViewTable" width="450" border="2" cellpadding="5" cellspacing="0" fram="hsides" rules="rows">
		    <tr>
				<td colspan="3">
					<span id="subject"></span>
				</td>
			</tr>
			
			<tr>
				<td width="150" align="center"></td>
				<td width="150" align="center"></td>
				<td width="150" align="center"></td>
			</tr>
			
			<tr>
				<td colspan="3" height="250" valign="top">
					<div style="width: 100%; height: 100%; overflow: auto;">
					 <!-- white-space: pre-wrap이 자동개행 -->
					<pre style="white-space: pre-line; word-break: break-ali"></pre>
					</div>
					</td>
			</tr>
			
			 
		</table>
		<input type="button" value="목록" onclick="#">
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/boardView.js"></script>

</body>
</html>