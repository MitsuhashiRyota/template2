package com.internousdev.komozon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.LogoutDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * LoginDAO変数
	 * user_infoテーブルにアクセスします。
	 */
	private LogoutDAO logoutDAO = new LogoutDAO();

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() {

		// メソッド内で利用する変数の初期化します。
		String result = SUCCESS;

		// user_infoテーブルに格納されているユーザログインフラグをログアウトに変更します。
		logoutDAO.updateLogined(session.get("userId").toString());

		// 共通Sessionに格納されている値を削除します。
		session.clear();

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session  = session;
	}


}
