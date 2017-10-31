package com.internousdev.komozon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.util.CreateTokenUtil;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	public Map<String, Object> session;

	/**
	 * ログインボタン押下時に実行
	 *
	 * @return SUCCSESS
	 */
	public String execute() {
		String result = SUCCESS;

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
