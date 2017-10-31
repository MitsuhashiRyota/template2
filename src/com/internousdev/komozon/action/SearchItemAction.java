package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.SearchItemDAO;
import com.internousdev.komozon.dto.CategoryItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private SearchItemDAO searchItemDAO = new SearchItemDAO();

	private List<CategoryItemDTO> categoryItemList = new ArrayList<>();

	public String searchText;

	public String category;

	public String execute() throws SQLException {

		String result = ERROR;

		categoryItemList = searchItemDAO.getSeachItems(searchText, category);
		session.put("categoryItemList", categoryItemList);

		result = SUCCESS;

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
