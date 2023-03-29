//$(function(){});
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: 'miniProject_jQuery/board/getBoard.do',
		data: {'seq': $('#seq').val(), 'pg': $('#pg').val()},
		dataType: 'json',
		success: function(data){
			$.each(data, function(index, items){
				
				$('#subject').text(items.subject)
			});
		}
	});





});