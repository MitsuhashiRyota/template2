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

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private List<BuyItemHistoryDTO> buyItemHistoryDTOList = new ArrayList<>();

	public List<BuyItemHistoryDTO> getBuyItemHistory(String userId) throws SQLException {

		String sql = "SELECT * FROM purchase_history_info INNER JOIN item_info ON item_info.item_id = purchase_history_info.item_id WHERE user_id = ?";

		connection = dbConnector.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

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
