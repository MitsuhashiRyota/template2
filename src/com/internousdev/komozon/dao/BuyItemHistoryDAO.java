package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.komozon.dto.BuyItemHistoryDTO;
import com.internousdev.komozon.util.DBConnector;

public class BuyItemHistoryDAO {

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
	 * List<BuyItemHistoryDTO>変数
	 * purchase_history_infoテーブルから取得した値を格納します。
	 */
	private List<BuyItemHistoryDTO> buyItemHistoryDTOList = new ArrayList<>();

	/**
	 * purchase_history_infoテーブルにアクセスし購入履歴情報を取得します。
	 * @param userId
	 * @return List<BuyItemHistoryDTO>
	 * @throws SQLException
	 */
	public List<BuyItemHistoryDTO> getBuyItemHistory(String userId) throws SQLException {

		// 実行するSQLの設定をします。
		String sql = "SELECT * FROM purchase_history_info INNER JOIN item_info ON item_info.item_id = purchase_history_info.item_id WHERE user_id = ?";

		connection = dbConnector.getConnection();

		try {
			// プリペアードステートメントを利用する設定をします。
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			// purchase_history_infoテーブルからまとめて取得した情報をList変数に格納します。
			while(resultSet.next()) {
				BuyItemHistoryDTO buyItemHistoryDTO = new BuyItemHistoryDTO();
				buyItemHistoryDTO.setCartItemId(resultSet.getString("item_id"));
				buyItemHistoryDTO.setItemName(resultSet.getString("item_name"));
				buyItemHistoryDTO.setItemPrice(resultSet.getInt("price"));
				buyItemHistoryDTO.setItemDescription(resultSet.getString("item_description"));
				buyItemHistoryDTO.setItemImagePath(resultSet.getString("image_file_path"));

				buyItemHistoryDTOList.add(buyItemHistoryDTO);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return buyItemHistoryDTOList;
	}
}
