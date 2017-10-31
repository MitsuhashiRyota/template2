package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CategoryItemBuyComplateDAO;
import com.internousdev.komozon.dto.CartItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryItemBuyComplateAction extends ActionSupport implements SessionAware{

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * CategoryItemBuyComplateDAO
	 * cart_infoテーブルにアクセスします。
	 */
	private CategoryItemBuyComplateDAO categoryItemBuyComplateDAO = new CategoryItemBuyComplateDAO();

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		// メソッド内で利用する変数の初期化
		String result = SUCCESS;

		// cart_infoテーブルにアクセスし、purchase_history_infoテーブルに値を格納します。
		categoryItemBuyComplateDAO.createUserCartInformationData((List<CartItemDTO>)session.get("cartItemDTOList"), session.get("userId").toString());

		// cart_infoテーブルにアクセスし情報の削除を行います。
		categoryItemBuyComplateDAO.deleteCartInfo(session.get("userId").toString());

		// 共通変数に格納されているカート情報を削除します。
		session.remove("cartItemDTOList");

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}