package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.komozon.util.DBConnector;

public class LogoutDAO {

	/**
	 * DBConnector変数
	 * DB接続設定値が格納されてます。
	 */
	private DBConnector dbConnector = new DBConnector();

	/**
	 * Connection変数
	 * DBに接続するための実行クラスが格納されてます。
	 */
	private Connection connection = dbConnector.getConnection();

	/**
	 * user_infoテーブルにアクセスし、ログインフラグの情報をログアウト状態に変更します。
	 * @param userId
	 * @return int
	 */
	public int updateLogined(String userId) {

		String sql = "UPDATE user_info SET logined = 0 WHERE user_id = ?";
		int resultCount = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			resultCount = preparedStatement.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return resultCount;
	}
}