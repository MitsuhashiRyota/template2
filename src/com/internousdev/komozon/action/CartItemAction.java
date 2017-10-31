package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.CartItemDAO;
import com.internousdev.komozon.dto.CartItemDTO;
import com.internousdev.komozon.dto.CategoryItemDTO;
import com.internousdev.komozon.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemAction extends ActionSupport implements SessionAware {

	/**
	 * Session変数
	 * JSPへ別クラス間で値の共有を行います。
	 */
	public Map<String, Object> session;

	/**
	 * CartItemDAO
	 * cart_infoテーブルにアクセスします。
	 */
	private CartItemDAO cartItemDAO = new CartItemDAO();

	/**
	 * List<CartItemCTO>
	 * カート情報テーブルから取得した複数の結果を格納します。
	 */
	private List<CartItemDTO> cartItemDTOList;

	/**
	 * Executeメソッド
	 * Struts.xmlで設定した実行メソッド
	 */
	public String execute() throws SQLException {

		// メソッド内で利用する変数の初期化
		String result = SUCCESS;
		String userId = null;

		// 確認対象のキーが生成されているか確認
		if(session.containsKey("categoryItemInfo")) {

			// ログイン情報が格納されているか確認
			if(session.containsKey("userInfo")) {
				LoginDTO loginDTO = (LoginDTO) session.get("userInfo");
				userId = loginDTO.getUserId();
			} else {
				userId = session.get("userId").toString();
			}

			// カート情報テーブルに値を格納
			int resultCount = cartItemDAO.createUserCartInformationData((CategoryItemDTO)session.get("categoryItemInfo"), userId);

			// 格納が成功した場合対象キーに紐づくデータを削除
			if(resultCount > 0) {
				session.remove("categoryItemInfo");
			}
		}

		// カード情報テーブルに格納されている情報を取得
		cartItemDTOList = cartItemDAO.getCartItemInfoList((CategoryItemDTO)session.get("categoryItemInfo"), userId);

		// 取得件数を確認
		if(cartItemDTOList.size() > 0) {
			session.put("cartItemDTOList", cartItemDTOList);
			result = SUCCESS;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
