package com.internousdev.komozon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.komozon.dto.CategoryItemDTO;
import com.internousdev.komozon.util.DBConnector;

public class SearchItemDAO {
	private DBConnector dbConnector = new DBConnector();

	private ArrayList<CategoryItemDTO> categoryItemDTOList = new ArrayList<CategoryItemDTO>();

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<CategoryItemDTO> getSeachItems(String searchText, String category) throws SQLException {

		Connection connection = dbConnector.getConnection();

		String sql = "";

		if(category.equals("0")) {
			sql = "select * from item_info where item_name like ?";
		} else {
			sql = "select * from item_info where item_name like ? AND category_id = ?";
		}

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + searchText + "%");

			if(!(category.equals("0"))) {
				preparedStatement.setString(2, category);
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

				System.out.println(categoryItemDTO.getItemName());
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
