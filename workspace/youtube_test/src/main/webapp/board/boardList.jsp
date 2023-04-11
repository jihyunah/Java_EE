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
				<p id="subject">게시글 제목</p>
				<p>게시글 내용입니다.</p>
				<p>작성자: 사용자이름 | 작성일: 2023-04-10</p>
			</div>
		</article>
		<article>
			<h2>게시글 제목</h2>
			<p>게시글 내용입니다.</p>
			<p>작성자: 사용자이름 | 작성일: 2023-04-10</p>
		</article>
		<form>
			<h2>게시글 작성</h2>
			<label for="title">제목</label>
			<input type="text" id="title" name="title" placeholder="제목을 입력하세요">
			<label for="content">내용</label>
			<textarea id="content" name="content" rows="10" placeholder="내용을 입력하세요"></textarea>
			<input type="submit" value="작성">
		</form>
	</section>
</body>
</html>
		