//$(function(){});
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoard.do',
		data: 'seq=' + $('#seq').val(), //{'seq' : $('#seq').val()}==> json
		dataType: 'json',
		success: function(data){
			alert(JSON.stringify(data)); //json의 형식으로 찍어라 
			
			$('#subjectSpan').text(data.subject);
			$('#seqSpan').text(data.seq);
			$('#idSpan').text(data.id);
			$('#hitSpan').text(data.hit);
			$('#contentSpan').text(data.content);
			
			
			
			
		},
		error: function(err){
			console.log(err);
		}
	});





});