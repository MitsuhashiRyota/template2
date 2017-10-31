<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<title>Home画面</title>
</head>
<body>
	<div id="header">
		<div id="hedImg">

		</div>
	 	<div id="navSearch">
	 		<form method="post" action="SearchItemAction">
	 		<div class="selectCategory">
	 			<select name="category" class="selectBox">
	 			<s:if test="category == 0">
	 				<option value="0" selected="selected">全てのカテゴリー</option>
	 			</s:if>
	 			<s:else>
		 			<option value="0" >全てのカテゴリー</option>
	 			</s:else>
	 			<s:if test="category == 1">
	 				<option value="1" selected="selected">本</option>
	 			</s:if>
	 			<s:else>
	 				<option value="1">本</option>
	 			</s:else>
	 			<s:if test="category == 2">
	 				<option value="2" selected="selected">家電・パソコン</option>
	 			</s:if>
	 			<s:else>
	 				<option value="2">家電・パソコン</option>
	 			</s:else>

	 			</select>
	 		</div>
	 		<div class="searchText">
	 		<s:if test="searchText != null">
	 			<input type="text" value="<s:property value="searchText" />" class="search" name="searchText" />
	 		</s:if>
	 		<s:else>
	 			<input type="text" value="" class="search" name="searchText" />
	 		</s:else>
	 		</div>
	 		<div class="searchSubmit">
	 			<input type="submit" value="検索" class="submit">
	 		</div>
	 		</form>
	 	</div>
	 	<div id="headerMenu">
	 		<ul id="menu">
		 		<li><a href="HomeAction">ホーム</a></li>
		 		<s:if test="session.userInfo.Logineds == 1">
		 		<li><a href="MyPageAction">マイページ</a></li>
		 		</s:if>
		 		<s:else>
		 		<li><a href="LoginAction">ログイン</a></li>
		 		</s:else>
		 		<li><a href="CartItemAction">カート</a></li>
		 		<li><a href="CategoryItemAction">商品</a></li>
		 		<s:if test="session.userInfo.Logineds == 1">
		 		<li><a href="LogoutAction">ログアウト</a></li>
		 		</s:if>
	 		</ul>
		</div>
	</div>