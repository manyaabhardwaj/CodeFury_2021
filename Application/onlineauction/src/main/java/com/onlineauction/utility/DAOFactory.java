package com.onlineauction.utility;

import com.onlineauction.dao.DAO;
import com.onlineauction.dao.DAOInterface;

public class DAOFactory {

	public static DAOInterface createDAOObject() {
		return new DAO();
	}
}