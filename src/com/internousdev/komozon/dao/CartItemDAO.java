package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.komozon.dto.CartItemDTO;
import com.internousdev.komozon.dto.CategoryItemDTO;
import com.internousdev.komozon.util.DBConnector;
import com.internousdev.komozon.util.DateUtil;
import com.sun.istack.internal.Nullable;

public class CartItemDAO {

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
	 * List<CartItemDTO>変数
	 * cart_infoテーブルから取得した値を格納します。
	 */
	private List<CartItemDTO> cartItemDTOList = new ArrayList<>();

	/**
	 * cart_infoテーブルにアクセスし、カートに入れた商品情報を登録します。
	 * @return int
	 * @throws SQLException
	 */
	public int createUserCartInformationData(CategoryItemDTO categoryItemDTO, @Nullable String userId) throws SQLException {

		connection = dbConnector.getConnection();
		String userNumber = "test";

		if(userId != null) {
			userNumber = userId;
		}

		String sql = "INSERT INTO cart_info(user_id, item_id, quantity, payment, insert_date, update_date) VALUES(?, ?, ?, ?, ?, ?)";
		String insertDate = DateUtil.getDate();
		int resultCount = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userNumber);
			preparedStatement.setInt(2, categoryItemDTO.getId());
			preparedStatement.setInt(3, 1);
			preparedStatement.setInt(4, 1);
			preparedStatement.setString(5, insertDate);
			preparedStatement.setString(6, insertDate);

			resultCount = preparedStatement.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return resultCount;
	}

	/**
	 * cart_infoテーブルにアクセスし、カート情報を取得します。
	 * @param categoryItemDTO
	 * @param userId
	 * @return List<CartItemDTO>
	 * @throws SQLException
	 */
	public List<CartItemDTO> getCartItemInfoList(CategoryItemDTO categoryItemDTO, @Nullable String userId) throws SQLException {

		String userNumber = "test";

		if(userId != null) {
			userNumber = userId;
		}

		String sql = "SELECT * FROM cart_info INNER JOIN item_info ON item_info.item_id = cart_info.item_id WHERE user_id = ?";

		connection = dbConnector.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userNumber);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				CartItemDTO cartItemDTO = new CartItemDTO();
				cartItemDTO.setCartItemId(resultSet.getString("item_id"));
				cartItemDTO.setItemName(resultSet.getString("item_name"));
				cartItemDTO.setItemPrice(resultSet.getInt("price"));
				cartItemDTO.setItemDescription(resultSet.getString("item_description"));
				cartItemDTO.setItemImagePath(resultSet.getString("image_file_path"));

				cartItemDTOList.add(cartItemDTO);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return cartItemDTOList;
	}

	/**
	 * cart_infoテーブルにアクセスし、user_id情報の更新を行います。
	 * @param tokenUserId
	 * @param userId
	 * @return int
	 */
	public int cartInfoUserIdUpdate(String tokenUserId, String userId) {
		String updateSql = "UPDATE cart_info SET user_id = ? WHERE user_id = ?";
		connection = dbConnector.getConnection();
		int resultCount = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, tokenUserId);

			resultCount = preparedStatement.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return resultCount;
	}
}
