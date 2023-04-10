<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    


<!DOCTYPE html>

<html>
<head>
	<title>커뮤니티 게시판</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
		body {
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
		}
		
		section {
			margin: 60px 500px 60px 200px;
		}
		article {
			border: 1px solid #333333;
			padding: 20px;
			margin-bottom: 20px;
			border-radius: 10px;
			width: 70%;
			height: 800px;
		}
		h1 {
			font-size: 28px;
			margin: 0;
		}
		h2 {
			font-size: 24px;
			margin: 0;
		}
		#subject {
			font-size: 15px;
		}
		p {
			font-size: 18px;
			line-height: 1.5;
			margin: 0 0 10px 0;
		}
		form {
			margin-top: 20px;
		}
		label {
			display: block;
			margin-bottom: 5px;
		}
		input[type="text"], textarea {
			width: 100%;
			padding: 10px;
			margin-bottom: 10px;
			box-sizing: border-box;
			border: 1px solid #333333;
			border-radius: 5px;
			resize: none;
		}
		input[type="submit"] {
			background-color: #333333;
			color: #FFFFFF;
			border: none;
			padding: 10px 20px;
			cursor: pointer;
			border-radius: 5px;
		}
		input[type="submit"]:hover {
			background-color: #FFFFFF;
			color: #333333;
		}
	</style>
</head>
<body>
	
	<section>
		<article>
			<p id="subject">
				<img src="/youtube_test/image/profile.png" width="35" height="35"
					onclick="" style="cursor: pointer">게시글 제목
			</p>
			<p>게시글 내용입니다.</p>
			<p>작성자: 사용자이름 | 작성일: 2023-04-10</p>
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
		