package com.internousdev.komozon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CartItemDAO;
import com.internousdev.komozon.dao.LoginDAO;
import com.internousdev.komozon.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 共通変数sessionを定義
	 */
	public Map<String, Object> session;

	/**
	 *
	 */
	private LoginDAO loginDAO = new LoginDAO();

	/**
	 *
	 */
	private LoginDTO loginDTO = new LoginDTO();

	/**
	 *
	 */
	public String userId;

	/**
	 *
	 */
	public String password;

	public CartItemDAO cartItemDAO = new CartItemDAO();

	/**
	 * Actionクラスが呼び出された際に一番最初に実行されるメソッド
	 * @return String
	 *   SUCCESS: 成功
	 */
	public String execute() {

		String result = SUCCESS;

		if(userId != null) {
			loginDTO = loginDAO.getLoginUserInfo(userId, password);

			if(loginDTO.getLogineds() > 0) {
				String tokenUserId = session.get("userId").toString();
				String userId = loginDTO.getUserId();
				cartItemDAO.cartInfoUserIdUpdate(tokenUserId, userId);

				session.put("userId", loginDTO.getUserId());
				session.put("userInfo", loginDTO);

				result = "logined";
			} else {
				session.put("loginError", "ログインIDまたはパスワードが異なります。");
			}

		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
