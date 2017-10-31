package com.internousdev.komozon.dto;

import java.time.LocalDateTime;

public class CategoryItemDTO {

	private int id;

	private String itemName;

	private String itemPrice;

	private int categoryId;

	private String itemImagePath;

	private String itemDescription;

	private String releaseDate;

	private LocalDateTime releaseLocalDateTime;

	public LocalDateTime getReleaseLocalDateTime() {
		return releaseLocalDateTime;
	}

	public void setReleaseLocalDateTime(LocalDateTime releaseLocalDateTime) {
		this.releaseLocalDateTime = releaseLocalDateTime;
	}

	private String releaseCompany;

	private int userRating;

	private String userRatingStar;

	public String getUserRatingStar() {
		return userRatingStar;
	}

	public void setUserRatingStar(String userRatingStar) {
		this.userRatingStar = userRatingStar;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String release_company) {
		this.releaseCompany = release_company;
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	private int itemSelectCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemImagePath() {
		return itemImagePath;
	}

	public void setItemImagePath(String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}

	public int getItemSelectCount() {
		return itemSelectCount;
	}

	public void setItemSelectCount(int itemSelectCount) {
		this.itemSelectCount = itemSelectCount;
	}
}
