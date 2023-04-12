<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    


<!DOCTYPE html>
<html>
<head>
<title>커뮤니티 게시판</title>
<link rel="stylesheet" href="/youtube_test/css/board.css">
</head>
<body>
	
	 <section>
		<article>
			<img src="/youtube_test/image/profile.png">
			<div class="content-info">
				<p class="subject">글 게시자<span>작성일</span></p>
				<p>게시글 내용입니다.</p>
				<p><img src="../image/jh.jpeg" class="image"></p>
				<p>
					<a href="#">
						<img src="/youtube_test/image/like.png" class="exBtn">
					</a><span id="likesu">605</span>
				</p>
			</div>
		</article>
		<article>
			<img src="/youtube_test/image/profile.png">
			<div class="content-info">
				<p class="subject">글 게시자<span>작성일</span></p>
				<p>게시글 내용입니다.</p>
				<p><img src="../image/jh.jpeg" class="image"></p>
			</div>
		</article>
		<!-- <form>
			<h2>게시글 작성</h2>
			<label for="title">제목</label>
			<input type="text" id="title" name="title" placeholder="제목을 입력하세요">
			<label for="content">내용</label>
			<textarea id="content" name="content" rows="10" placeholder="내용을 입력하세요"></textarea>
			<input type="submit" value="작성">
		</form> -->
	</section>
	
	
</body>
</html>
		