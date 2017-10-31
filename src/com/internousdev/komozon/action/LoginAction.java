package com.internousdev.komozon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CartItemDAO;
import com.internousdev.komozon.dao.LoginDAO;
import com.internousdev.komozon.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * LoginDAO変数
	 * user_infoテーブルにアクセスします。
	 */
	private LoginDAO loginDAO = new LoginDAO();

	/**
	 * LoginDTO変数
	 * user_infoテーブルから取得した値を格納します。
	 */
	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * UserID変数
	 * login.jspで入力したログインIDを取得します。
	 */
	public String userId;

	/**
	 * Password変数
	 * login.jspで入力したパスワードを取得します。
	 */
	public String password;

	/**
	 * CartItemDAO変数
	 * cart_infoテーブルから取得した値を格納します。
	 */
	public CartItemDAO cartItemDAO = new CartItemDAO();

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() {

		// メソッド内で利用する変数の初期化します。
		String result = SUCCESS;

		// ログインIDとパスワードが入力されているかを確認します。
		if((userId != null) && (password != null)) {

			// 入力されたログインIDとパスワードからuser_infoテーブルに値の参照を行います。
			loginDTO = loginDAO.getLoginUserInfo(userId, password);

			// user_infoテーブルから取得した値がLoginDTOに格納されているかを確認します。
			if(loginDTO.getLogineds() > 0) {

				// 未ログイン時にカートに入れた情報をログイン後に引き継ぐ為の処理
				String tokenUserId = session.get("userId").toString();
				String userId = loginDTO.getUserId();

				// 一時トークン情報とユーザーIDを利用して、カート情報の引継ぎを行います。
				cartItemDAO.cartInfoUserIdUpdate(tokenUserId, userId);

				session.put("userId", loginDTO.getUserId());
				session.put("userInfo", loginDTO);

				result = "logined";
			} else {

				// 入力に誤りがあるのでエラーメッセージを格納します。
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