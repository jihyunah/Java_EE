$(document).ready(function(){
   $.ajax({
      type: 'post',
      url: '/miniProject_jQuery/board/getBoard.do',
      data: 'seq='+$('#seq').val(), //{'seq' : $('#seq').val()}
      dataType: 'json',
      
      success: function(data){
         //alert(JSON.stringify(data));
         
         $('#subjectSpan').text(data.subject);
         $('#seqSpan').text(data.seq);
         $('#idSpan').text(data.id);
         $('#hitSpan').text(data.hit);
         $('#contentSpan').text(data.content);
         
         //자신의 글인지 확인
         if($('#memId').val() == data.id){
            $('#boardViewSpan').show();
         }
         else{
            $('#boardViewSpan').hide();
         }
         
         
      },
      error: function(err){
         console.log(err);
      }
   });
});

//글 수정 폼 
$('#boardUpdateFormBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_jQuery/board/boardUpdateForm.do');
	$('#boardViewForm').submit(); //input 상자의 내용들 다 가져갈 수 있음. submit은 id속성을 못가져 가고 name 속성만 가능. 
});

//답글 쓰기 폼
$('#boardReplyFormBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_jQuery/board/boardReplyForm.do');
	$('#boardViewForm').submit(); //name 속성이 있는 seq, pg 데이터가 넘어간다. (name 속성 없는 memId는 못간다.)
});
























