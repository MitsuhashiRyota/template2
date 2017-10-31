package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.komozon.dto.CategoryItemDTO;
import com.internousdev.komozon.util.DBConnector;

public class CategoryItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private ArrayList<CategoryItemDTO> categoryItemDTOList = new ArrayList<CategoryItemDTO>();

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<CategoryItemDTO> getCategoryItems(int id) throws SQLException {

		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM item_info where category_id = ? ORDER BY id ASC LIMIT 12 OFFSET ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			if(id != 0) {
				preparedStatement.setInt(2, id);
			} else {
				preparedStatement.setInt(2, 0);
			}

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				CategoryItemDTO categoryItemDTO = new CategoryItemDTO();

				categoryItemDTO.setId(resultSet.getInt("id"));
				categoryItemDTO.setItemName(resultSet.getString("item_name"));
				categoryItemDTO.setItemPrice(resultSet.getString("price"));
				categoryItemDTO.setCategoryId(resultSet.getInt("category_id"));
				categoryItemDTO.setItemDescription(resultSet.getString("item_description"));
				categoryItemDTO.setItemImagePath(resultSet.getString("image_file_path"));

				categoryItemDTOList.add(categoryItemDTO);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return categoryItemDTOList;
	}
}
