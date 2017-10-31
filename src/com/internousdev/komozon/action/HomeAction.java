package com.internousdev.komozon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.util.CreateTokenUtil;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() {

		// メソッド内で利用する変数の初期化
		String result = SUCCESS;

		// ログイン状態であるかを確認、ログイン状態でない場合は一時認証トークンを発行
		if(!(session.containsKey("userId"))) {
			// 一時トークン発行
			session.put("userId", CreateTokenUtil.createToken());
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
