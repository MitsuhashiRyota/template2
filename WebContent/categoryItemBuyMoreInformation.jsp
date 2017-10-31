<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ include file="header.jsp" %>
	<div id="main">
	<%@ include file="leftNavi.jsp" %>
		<div id="container">
			<div class="itemMoreln">
				<p>商品番号：<s:property value="session.categoryItemInfo.Id" /></p>
				<p>商品名：<s:property value="session.categoryItemInfo.ItemName" /></p>
				<p>価格：<s:property value="session.categoryItemInfo.ItemPrice" /></p>
				<p>発売年月：<s:property value="session.categoryItemInfo.ReleaseLocalDateTime" />発行</p>
				<p>発売会社：<s:property value="session.categoryItemInfo.ReleaseCompany" /></p>
				<p>ユーザー評価：<s:property value="session.categoryItemInfo.UserRatingStar" /></p>
			</div>
			<div class="itemImage">
				<img alt="" src="<s:property value="session.categoryItemInfo.ItemImagePath"/>"  width="250" height="250">
				<s:form action="CartItemAction">
					<s:submit value="カートに追加" />
				</s:form>
			</div>
			<div class="bookInfo">
				<p>本にまつわる情報を表示します。本にまつわる情報を表示します。本にまつわる情報を表示します。</p>
			</div>
		</div>
		<div id="differentItems">
		<s:iterator value="session.categoryItemList" status="cnt">
		<s:if test="#cnt.index < 8">
			<div class="differentList">
				<div><p><s:property value="session.categoryItemList[#cnt.index].itemName" /></p></div>
				<div>
					<a href='<s:url action="CategoryItemMoreInformationAction"><s:param name="id" value="session.categoryItemList[#cnt.index].id" /></s:url>'>
						<img alt="" src="<s:property value="session.categoryItemList[#cnt.index].itemImagePath" />" width="80" height="80">
					</a>
				</div>
			</div>
		</s:if>
		</s:iterator>
		</div>
	</div>
	<%@ include file="footer.jsp" %>