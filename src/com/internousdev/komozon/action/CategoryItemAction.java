package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CategoryItemDAO;
import com.internousdev.komozon.dto.CategoryItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryItemAction extends ActionSupport implements SessionAware{

	private CategoryItemDAO categoryItemDAO = new CategoryItemDAO();

	private List<CategoryItemDTO> categoryItemList = new ArrayList<>();

	public Map<String, Object> session;

	public int id;

	public String execute() throws SQLException {

		String result = SUCCESS;

		setCategoryItemList(categoryItemDAO.getCategoryItems(id));
		session.put("categoryItemList", categoryItemList);

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<CategoryItemDTO> getCategoryItemList() {
		return categoryItemList;
	}

	public void setCategoryItemList(List<CategoryItemDTO> categoryItemList) {
		this.categoryItemList = categoryItemList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
