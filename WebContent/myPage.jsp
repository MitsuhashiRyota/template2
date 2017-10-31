<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <%@ include file="header.jsp" %>
        <p>購入商品一覧</p>
    	<div id="cart_list">
    	<s:iterator value="session.buyItemHistoryDTOList" status="count">
    	<s:if test="#count.index < 5">
			<div class="cart_item">
				<div class="cartItemImage">
					<img alt="" src="<s:property value="session.buyItemHistoryDTOList[#count.index].itemImagePath" />" class="itemImageArea">
				</div>
				<div class="itemInfo">
					<p>
						<a href='<s:url action="CategoryItemMoreInformationAction" />'>
						<s:property value="session.buyItemHistoryDTOList[#count.index].ItemName"/>
						</a>
					</p>
					<p>
						<s:property value="session.buyItemHistoryDTOList[#count.index].ItemDescription"/>
					</p>
				</div>
				<div class="itemPrice">
					<p>価格</p>
					<div class="itemPriceArea">
						<s:property value="session.cartItemDTOList[#count.index].ItemPrice"/>
					</div>
				</div>
			</div>
		</s:if>
		</s:iterator>
		</div>
	<%@ include file="footer.jsp" %>