package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.BuyItemHistoryDAO;
import com.internousdev.komozon.dto.BuyItemHistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * BuyItemHistoryDAO変数
	 * purchase_history_infoテーブルにアクセスします。
	 */
	private BuyItemHistoryDAO buyItemHistoryDAO = new BuyItemHistoryDAO();

	/**
	 *  List<BuyItemHistoryDTO>変数
	 *  purchase_history_infoテーブルから取得した値を格納します。
	 */
	private List<BuyItemHistoryDTO> buyItemHistoryDTOList;

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() throws SQLException {

		// メソッド内で利用する変数の初期化します。
		String result =  SUCCESS;

		// purchase_history_infoテーブルにアクセスし、購入履歴情報を取得します。
		buyItemHistoryDTOList = buyItemHistoryDAO.getBuyItemHistory(session.get("userId").toString());
		session.put("buyItemHistoryDTOList", buyItemHistoryDTOList);

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
