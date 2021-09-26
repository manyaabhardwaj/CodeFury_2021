package com.onlineauction.service;

import java.util.List;

import com.onlineauction.dao.DAOInterface;
import com.onlineauction.exception.ActualGreaterThanMinimum;
import com.onlineauction.exception.IncorrectCredentialsException;
import com.onlineauction.exception.UserAlreadyExistsException;
import com.onlineauction.model.Auction;
import com.onlineauction.model.OpenProducts;
import com.onlineauction.model.Product;
import com.onlineauction.model.User;
import com.onlineauction.utility.DAOFactory;

public class Service implements ServiceInterface {

	private DAOInterface dao;
	public Service() {
		 dao = DAOFactory.createDAOObject(); 
	}
	
	public int register(User object) throws UserAlreadyExistsException{
		return dao.registerUser(object);
	}

	public User login(User object) throws IncorrectCredentialsException {
		return dao.loginUser(object);
	}
	
	public int addProduct(Product object) {
		return dao.addProduct(object);
	}

	public User displaySeller(User object) {
		return dao.displaySeller(object);
	}

	@Override
	public int scheduleAuction(Auction auctionobject, User object) throws ActualGreaterThanMinimum {
		return dao.scheduleAuction(auctionobject, object);
	}
	
	public List<Product> displayAllProduct(User object) {
		return dao.displayallProduct(object);
	}

	@Override
	public OpenProducts displaySellerProduct(User object) {
		return dao.displaysellerproduct(object);
	}

	public List<OpenProducts> homepageDisplayAllProducts() {
		return dao.homepageDisplayAll();
	}
}