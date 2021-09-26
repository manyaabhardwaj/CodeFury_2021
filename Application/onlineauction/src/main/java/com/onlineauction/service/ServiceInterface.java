package com.onlineauction.service;


import java.util.List;

import com.onlineauction.exception.ActualGreaterThanMinimum;
import com.onlineauction.exception.IncorrectCredentialsException;
import com.onlineauction.exception.UserAlreadyExistsException;
import com.onlineauction.model.Auction;
import com.onlineauction.model.OpenProducts;
import com.onlineauction.model.Product;
import com.onlineauction.model.User;

public interface ServiceInterface {

	int register(User object) throws UserAlreadyExistsException;

	User login(User object) throws IncorrectCredentialsException;

	int addProduct(Product object);

	User displaySeller(User object);

	int scheduleAuction(Auction auctionobject, User object) throws ActualGreaterThanMinimum;

	List<Product> displayAllProduct(User object);

	OpenProducts displaySellerProduct(User object);

	List<OpenProducts> homepageDisplayAllProducts();

}
