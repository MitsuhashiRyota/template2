package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CartItemDAO;
import com.internousdev.komozon.dto.CartItemDTO;
import com.internousdev.komozon.dto.CategoryItemDTO;
import com.internousdev.komozon.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemAction extends ActionSupport implements SessionAware {

	/**
	 *
	 */
	public Map<String, Object> session;

	/**
	 *
	 */
	private CartItemDAO cartItemDAO = new CartItemDAO();

	/**
	 *
	 */
	private List<CartItemDTO> cartItemDTOList;

	/**
	 *
	 */
	public String execute() throws SQLException {

		String result = SUCCESS;
		String userId = null;

		if(session.containsKey("categoryItemInfo")) {
			if(session.containsKey("userInfo")) {
				LoginDTO loginDTO = (LoginDTO) session.get("userInfo");
				userId = loginDTO.getUserId();
			} else {
				userId = session.get("userId").toString();
			}

			int resultCount = cartItemDAO.createUserCartInformationData((CategoryItemDTO)session.get("categoryItemInfo"), userId);

			if(resultCount > 0) {
				session.remove("categoryItemInfo");
			}
		}

		cartItemDTOList = cartItemDAO.getCartItemInfoList((CategoryItemDTO)session.get("categoryItemInfo"), userId);

		if(cartItemDTOList.size() > 0) {
			session.put("cartItemDTOList", cartItemDTOList);
			result = SUCCESS;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
