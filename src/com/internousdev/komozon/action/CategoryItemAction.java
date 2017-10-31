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

	/**
	 * CategoryItemDAO変数
	 * category_infoテーブルにアクセスします。
	 */
	private CategoryItemDAO categoryItemDAO = new CategoryItemDAO();

	/**
	 * List<CategoryItemDAO>変数
	 * category_infoテーブルから取得した商品情報を格納します。
	 */
	private List<CategoryItemDTO> categoryItemList = new ArrayList<>();

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() throws SQLException {

		// メソッド内で利用する変数の初期化
		String result = SUCCESS;

		// cateroryItemテーブルにアクセスし、商品情報を取得します。
		setCategoryItemList(categoryItemDAO.getCategoryItems());
		session.put("categoryItemList", categoryItemList);

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * List<CategoryItemDTO>変数の取得メソッド
	 * @return List<CategoryItemDTO>
	 */
	public List<CategoryItemDTO> getCategoryItemList() {
		return categoryItemList;
	}

	/**
	 * List<CategoryItemDTO>変数への格納メソッド
	 * @param categoryItemList
	 */
	public void setCategoryItemList(List<CategoryItemDTO> categoryItemList) {
		this.categoryItemList = categoryItemList;
	}

}
