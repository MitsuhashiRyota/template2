package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.internousdev.komozon.dto.CartItemDTO;
import com.internousdev.komozon.util.DBConnector;
import com.internousdev.komozon.util.DateUtil;

public class CategoryItemBuyComplateDAO {

	/**
	 * DBConnector変数
	 * DB接続設定値が格納されてます。
	 */
	private DBConnector dbConnector = new DBConnector();

	/**
	 * Connection変数
	 * DBに接続するための実行クラスが格納されてます。
	 */
	private Connection connection;

	/**
	 * 商品購入情報を登録
	 * @return
	 * @throws SQLException
	 */
	public int createUserCartInformationData(List<CartItemDTO> cartItemDTOList, String userId) throws SQLException {

		connection = dbConnector.getConnection();

		String sql = "INSERT INTO purchase_history_info(user_id, item_id, quantity, payment, insert_date, update_date) VALUES(?, ?, ?, ?, ?, ?)";
		String insertDate = DateUtil.getDate();
		int resultCount = 0;

		try {

			for(int i=0; i < cartItemDTOList.size(); i++) {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, Integer.parseInt(cartItemDTOList.get(i).getCartItemId()));
			preparedStatement.setInt(3, 1);
			preparedStatement.setInt(4, 1);
			preparedStatement.setString(5, insertDate);
			preparedStatement.setString(6, insertDate);

			resultCount = preparedStatement.executeUpdate();
		}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return resultCount;
	}

	/**
	 * cart_infoテーブルにアクセスし、対象のデータを削除します。
	 * @param userId
	 * @return int
	 * @throws SQLException
	 */
	public int deleteCartInfo(String userId) throws SQLException {
		connection = dbConnector.getConnection();

		String sql = "DELETE FROM cart_info WHERE user_id = ?";
		int resultCount = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);

			resultCount = preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return resultCount;

	}
}
