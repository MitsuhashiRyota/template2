package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.komozon.util.DBConnector;

public class LogoutDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

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
