<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <%@ include file="header.jsp" %>
        <p>購入商品最終確認</p>
    	<div id="main">
			<s:form action="CategoryItemBuyComplateAction">
	    	<s:iterator value="session.cartItemDTOList" status="count">
	    	<s:if test="#count.index < 5">
				<div class="cart_item">
					<div class="cartItemImage">
						<img alt="" src="<s:property value="session.cartItemDTOList[#count.index].itemImagePath" />" class="itemImageArea">
					</div>
					<div class="itemInfo">
						<p>
							<a href='<s:url action="CategoryItemMoreInformationAction" />'>
							<s:property value="session.cartItemDTOList[#count.index].ItemName"/>
							</a>
						</p>
						<p>
							<s:property value="session.cartItemDTOList[#count.index].ItemDescription"/>
						</p>
					</div>
					<div class="itemPrice">
						<p>価格</p>
						<div class="itemPriceArea">
							<s:property value="session.cartItemDTOList[#count.index].ItemPrice"/>
						</div>
					</div>
					<div class="itemDelete">
						<button type="submit" value="" class="deleteBtn"></button>
						<span class="deleteWord">削除</span>
					</div>
				</div>
				</s:if>
			</s:iterator>
			<s:submit value="完了" />
		</s:form>
		<s:form action="CartItemAction">
			<button type="submit">戻る</button>
		</s:form>
		</div>
	<%@ include file="footer.jsp" %>