package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CategoryItemBuyComplateDAO;
import com.internousdev.komozon.dto.CartItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryItemBuyComplateAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private CategoryItemBuyComplateDAO categoryItemBuyComplateDAO = new CategoryItemBuyComplateDAO();

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		categoryItemBuyComplateDAO.createUserCartInformationData((List<CartItemDTO>)session.get("cartItemDTOList"), session.get("userId").toString());
		categoryItemBuyComplateDAO.deleteCartInfo(session.get("userId").toString());

		session.remove("cartItemDTOList");

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
