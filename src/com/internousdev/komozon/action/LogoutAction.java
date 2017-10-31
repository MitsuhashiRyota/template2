package com.internousdev.komozon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.komozon.dao.LogoutDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private LogoutDAO logoutDAO = new LogoutDAO();

	public String execute() {
		String result = SUCCESS;
		logoutDAO.updateLogined(session.get("userId").toString());
		session.clear();

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session  = session;
	}


}
