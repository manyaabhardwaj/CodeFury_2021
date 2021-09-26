package com.onlineauction.dao;

import com.onlineauction.model.Auction;
import com.onlineauction.model.OpenProducts;

import java.util.List;

import com.onlineauction.exception.ActualGreaterThanMinimum;
import com.onlineauction.exception.IncorrectCredentialsException;
import com.onlineauction.exception.UserAlreadyExistsException;
import com.onlineauction.model.Product;
import com.onlineauction.model.User;

public interface DAOInterface {
	
	public int registerUser(User object) throws UserAlreadyExistsException;

	public User loginUser(User object) throws IncorrectCredentialsException;

	public int addProduct(Product object);

	public User displaySeller(User object);

	public int scheduleAuction(Auction auctionobject, User object) throws ActualGreaterThanMinimum;

	public void backgroundTask();

	public List<Product> displayallProduct(User object);
	
	public OpenProducts displaysellerproduct(User object);

	public List<OpenProducts> homepageDisplayAll();
		
}