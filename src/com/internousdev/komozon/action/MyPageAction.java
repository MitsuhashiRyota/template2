package com.internousdev.komozon.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.BuyItemHistoryDAO;
import com.internousdev.komozon.dto.BuyItemHistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private List<BuyItemHistoryDTO> buyItemHistoryDTOList;

	private BuyItemHistoryDAO buyItemHistoryDAO = new BuyItemHistoryDAO();

	public String execute() throws SQLException {
		String result =  SUCCESS;

		buyItemHistoryDTOList = buyItemHistoryDAO.getBuyItemHistory(session.get("userId").toString());
		session.put("buyItemHistoryDTOList", buyItemHistoryDTOList);

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
