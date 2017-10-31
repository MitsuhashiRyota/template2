<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="header.jsp" %>
    <div id="main">
	<%@ include file="leftNavi.jsp" %>
		<div id="container">
	    	<div id="cart_list" class="left">
	    	<s:if test="session.cartItemDTOList != null">
		    	<s:form action="CategoryItemBuyConfirmAction">
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
					<s:submit value="購入" />
				</s:form>
				</s:if>
				<s:else>
					<div class="not_cart_item">
						<h3>カートに入っている商品がありません。</h3>
					</div>
				</s:else>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>