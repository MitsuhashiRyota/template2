package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CategoryItemBuyMoreInformationDAO;
import com.internousdev.komozon.dto.CategoryItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryItemMoreInformationAction extends ActionSupport implements SessionAware{

	/**
	 * 共通変数sessionを定義
	 */
	public Map<String, Object> session;

	/**
	 *
	 */
	private String id;

	/**
	 *
	 */
	private CategoryItemBuyMoreInformationDAO categoryItemBuyMoreInformationDAO = new CategoryItemBuyMoreInformationDAO();

	/**
	 *
	 */
	private CategoryItemDTO categoryItemDTO = new CategoryItemDTO();

	/**
	 *
	 */
	public List<CategoryItemDTO> categoryItemList = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		// 選択した商品情報から商品の詳細レコードを取得
		categoryItemDTO = categoryItemBuyMoreInformationDAO.getSelectCategoryItems(getId());

		switch (categoryItemDTO.getUserRating()) {
			case 0:
				categoryItemDTO.setUserRatingStar("☆☆☆☆☆");
				break;
			case 1:
				categoryItemDTO.setUserRatingStar("★☆☆☆☆");
				break;
			case 2:
				categoryItemDTO.setUserRatingStar("★★☆☆☆");
				break;
			case 3:
				categoryItemDTO.setUserRatingStar("★★★☆☆");
				break;
			case 4:
				categoryItemDTO.setUserRatingStar("★★★★☆");
				break;
			default:
				categoryItemDTO.setUserRatingStar("★★★★★");
				break;
		}

		categoryItemList = (List<CategoryItemDTO>) session.get("categoryItemList");

		// DAOから取得した結果Sessionに格納
		session.put("categoryItemInfo", categoryItemDTO);

		return SUCCESS;
	}

	/**
	 * ID取得メソッド
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * ID格納メソッド
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
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

}
