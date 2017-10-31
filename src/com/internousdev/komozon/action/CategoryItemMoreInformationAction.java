package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CategoryItemBuyMoreInformationDAO;
import com.internousdev.komozon.dto.CategoryItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryItemMoreInformationAction extends ActionSupport implements SessionAware{

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * id変数
	 * 選択した商品のIDを格納します。
	 */
	private String id;

	/**
	 * CategoryItemBuyMoreInformationDAO変数
	 * cart_infoテーブルにアクセスします。
	 */
	private CategoryItemBuyMoreInformationDAO categoryItemBuyMoreInformationDAO = new CategoryItemBuyMoreInformationDAO();

	/**
	 * CategoryItemDTO変数
	 * cart_infoテーブルにアクセスして取得した値を格納します。
	 */
	private CategoryItemDTO categoryItemDTO = new CategoryItemDTO();

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() throws SQLException {

		// メソッド内で利用する変数の初期化
		String result = SUCCESS;

		// 選択した商品情報から商品の詳細レコードを取得
		categoryItemDTO = categoryItemBuyMoreInformationDAO.getSelectCategoryItems(getId());

		// 評価星の設定を行います。
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

		// DAOから取得した結果Sessionに格納
		session.put("categoryItemInfo", categoryItemDTO);

		return result;
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
}
