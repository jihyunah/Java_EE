<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>
#boardWriteForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
/* #subjectDiv {
	color: red;
	font-size: 8pt;
	font-weight: bold;
} */
</style>
</head>
<body>
<h3>
<img src="../image/1.png" width="50" height="50" alt="찰칵" 
onclick="location.href='../index.jsp'" style="cursor:pointer";>글쓰기 
</h3>
<form name="boardWriteForm" id="boardWriteForm">

		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" id="subject" placeholder="제목입력" size="50">
					<div id="subjectDiv"></div>
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" id="content" placeholder="내용 입력" cols="50" rows="15"></textarea>
					<div id="contentDiv"></div>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" id="boardWriteBtn">
					<input type="reset" value="다시작성">
				</td>
			</tr>
			
		</table>
</form>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$('#boardWriteBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty(); //초기화 
	
	if( $('#subject').val() == '' ){
		$('#subjectDiv').text('제목 입력');
		$('#subjectDiv').css('color', 'red');
		$('#subjectDiv').css('font', '8pt bold')
		$('#subject').focus();
	}
	
	else if( $('#content').val() == '' ){
		$('#contentDiv').text('내용 입력');
		$('#contentDiv').css('color', 'red');
		$('#contentDiv').css('font', '8pt bold')
		$('#content').focus();
	}

	else {
		$.ajax({ //갔다가 다시 돌아온다.
			type: 'post',
			url: '/miniProject_jQuery/board/boardWrite.do',
			data: $('#boardWriteForm').serialize(), 
			//2. 'subject=' + $('#subject').val() + '&content=' + $('#content').val()
			//3. {'subject' : $('#subject').val(), 'content': $('#content').val()}
			success: function(){
				alert('글 작성 완료!!');
				location.href='../index.jsp';
			},
			error: function(err){
				console.log(err);
			}
			
		});
		
	}
	
});


/* 
	function checkBoardWrite(){
		document.getElementById("subjectDiv").innerText="";
		document.getElementById("contentDiv").innerText="";
		
		if(document.getElementById("subject").value == "") {
			document.getElementById("subjectDiv").innerText = "제목을 입력하세요";
			document.getElementById("subject").focus();
	}
		else if(document.getElementById("content").value == "") {
			document.getElementById("contentDiv").innerText = "내용을 입력";
			document.getElementById("content").focus();
		}
		else document.boardWriteForm.submit();
	} */
</script>
</body>
</html>