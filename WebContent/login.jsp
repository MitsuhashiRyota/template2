<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>

    <%@ include file="header.jsp" %>
    <div id="main">
    <%@ include file="leftNavi.jsp" %>
		<div id="container">
			<div class="homeImage">
			<s:property value="session.loginError"/>
				<h3>商品を購入する際にはログインをお願いします。</h3>
				<s:form action="LoginAction">
					<s:textfield name="userId"/>
					<s:password name="password"/>
					<s:submit value="ログイン"/>
				</s:form>
				<br/>
				<div>
					<span>新規ユーザー登録は<a href='<s:url action="UserCreateAction" />'>こちら</a></span>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>