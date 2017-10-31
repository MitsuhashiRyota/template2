package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.komozon.dto.CategoryItemDTO;
import com.internousdev.komozon.util.DBConnector;

public class CategoryItemBuyMoreInformationDAO {

	private DBConnector dbConnector = new DBConnector();

	private CategoryItemDTO categoryItemDTO = new CategoryItemDTO();

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public CategoryItemDTO getSelectCategoryItems(String id) throws SQLException {

		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM item_info where id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				categoryItemDTO.setId(resultSet.getInt("id"));
				categoryItemDTO.setItemName(resultSet.getString("item_name"));
				categoryItemDTO.setItemPrice(resultSet.getString("price"));
				categoryItemDTO.setCategoryId(resultSet.getInt("category_id"));
				categoryItemDTO.setItemImagePath(resultSet.getString("image_file_path"));
				categoryItemDTO.setItemDescription(resultSet.getString("item_description"));
				categoryItemDTO.setReleaseDate(resultSet.getString("release_date"));
				categoryItemDTO.setReleaseCompany(resultSet.getString("release_company"));
				categoryItemDTO.setUserRating(resultSet.getInt("user_rating"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return categoryItemDTO;
	}
}
