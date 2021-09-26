package com.auction.trial;

import java.util.TimerTask;

import com.onlineauction.dao.DAOInterface;
import com.onlineauction.utility.DAOFactory;

public class BackgroundTask extends TimerTask {

	private DAOInterface dao;
	public BackgroundTask() {
		 dao = DAOFactory.createDAOObject(); 
	}
	
	public void run() {
		System.out.println("Running every minute");
		dao.backgroundTask();
	}
}