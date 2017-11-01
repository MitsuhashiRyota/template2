<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ include file="header.jsp" %>
	<div id="main">
	<%@ include file="leftNavi.jsp" %>
		<div id="container">
		<s:iterator status="cnt" value="session.categoryItemList">
			<s:if test="#cnt.index < 12">
			<div class="items">
				<div>
					<p>
						<s:property value="session.categoryItemList[#cnt.index].itemName" />
					</p>
				</div>
				<div>
					<p>
						<a href='<s:url action="CategoryItemMoreInformationAction"><s:param name="id" value="session.categoryItemList[#cnt.index].id" /></s:url>'>
							<img border="0" src="<s:property value="session.categoryItemList[#cnt.index].itemImagePath" />" width="128" height="128" alt="イラスト1">
						</a>
					</p>
				</div>
				<div>
					<p>
						<s:property value="categoryItemList[#cnt.index].itemPrice" />円
					</p>
				</div>
				<div>
					<p>
						カテゴリ：
						<s:if test="categoryItemList[#cnt.index].categoryId == 1">
							本
						</s:if>
						<s:elseif test="categoryItemList[#cnt.index].categoryId == 2">
							家電・パソコン
						</s:elseif>

					</p>
				</div>
				<div>
					<p>
						<s:property value="categoryItemList[#cnt.index].description" />
					</p>
				</div>
			</div>
		</s:if>
		</s:iterator>
		</div>
	</div>
	<%@ include file="footer.jsp" %>