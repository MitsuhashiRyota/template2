<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ include file="header.jsp" %>
	<div id="main">
		<p>indexです</p>
		<a href='<s:url action="LoginAction" />'>ログインへ</a>
		<br>
		<a href='<s:url action="CategoryItemAction" />'>カテゴリアイテムへ</a>
		<div>
			<p>注目アイテムです</p>
			<p>1</p>
			<p>2</p>
			<p>3</p>
		</div>
	</div>
	<%@ include file="footer.jsp" %>