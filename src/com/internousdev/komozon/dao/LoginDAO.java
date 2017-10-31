package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.komozon.dto.LoginDTO;
import com.internousdev.komozon.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * ログインユーザ情報取得メソッド
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO
	 */
	public LoginDTO getLoginUserInfo(String userId, String password) {

		String sql = "SELECT * FROM user_info where user_id = ? AND password = ? AND status = 1";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				loginDTO.setUserId(resultSet.getString("user_id"));
				loginDTO.setPassword(resultSet.getString("password"));
				loginDTO.setUserName(resultSet.getString("family_name") + resultSet.getString("first_name"));

				if(!(resultSet.getString("logined").equals(0))) {
					loginDTO.setLogineds(1);

					String updateSql = "UPDATE user_info SET logined = ? WHERE user_id = ?";
					PreparedStatement updateStatement = connection.prepareStatement(updateSql);

					updateStatement.setInt(1, loginDTO.getLogineds());
					updateStatement.setString(2, loginDTO.getUserId());
					updateStatement.executeUpdate();
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return loginDTO;
	}
}
