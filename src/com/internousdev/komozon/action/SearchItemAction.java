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

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * SearchItemDAO変数
	 * item_infoテーブルにアクセスします。
	 */
	private SearchItemDAO searchItemDAO = new SearchItemDAO();

	/**
	 * List<CategoryItemDTO>変数
	 * item_infoテーブルから取得した値を格納します。
	 */
	private List<CategoryItemDTO> categoryItemList = new ArrayList<>();

	/**
	 * searchText変数
	 * 検索文言
	 */
	public String searchText;

	/**
	 * category変数
	 * 選択カテゴリー
	 */
	public String category;

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() throws SQLException {

		// メソッド内で利用する変数の初期化
		String result = SUCCESS;

		// item_infoテーブルにアクセスし、検索文言とカテゴリーから絞り込んだ結果を取得します。
		categoryItemList = searchItemDAO.getSeachItems(searchText, category);
		session.put("categoryItemList", categoryItemList);

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
