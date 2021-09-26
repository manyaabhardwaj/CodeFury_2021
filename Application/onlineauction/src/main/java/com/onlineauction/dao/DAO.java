package com.onlineauction.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.onlineauction.exception.ActualGreaterThanMinimum;
import com.onlineauction.exception.IncorrectCredentialsException;
import com.onlineauction.exception.UserAlreadyExistsException;
import com.onlineauction.model.Auction;
import com.onlineauction.model.OpenProducts;
//Imports from model package
import com.onlineauction.model.Product;
import com.onlineauction.model.User;

public class DAO implements DAOInterface {
	
	// Global Statements
	private PreparedStatement register,login,lastloggedin,addProduct,displaySeller,viewProfile,findSellerId,scheduleAuction,updateStatusCompleted,
	displayAllProduct,getActualPrice,displaySellerProducts, homePageDisplay;
	private Connection con;
	
	// Define constructor and initialize statements
	public DAO() {
		try {
			// Load Drivers
			Class.forName("com.mysql.jdbc.Driver");
			// Create connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineauction","root","ssk_230399");
			// Initialize Statements
			register = con.prepareStatement("insert into users(name, dateofbirth, email, phonenumber, "
					+ "username, password, address, typeofuser,walletamount) values(?,?,?,?,?,?,?,?,?);");
			/*
			register = con.prepareStatement("insert into users(name, email, phonenumber, "
					+ "username, password, address, typeofuser,walletamount) values(?,?,?,?,?,?,?,?);");
			*/
			login = con.prepareStatement("select typeofuser,userid from users where username=? and password=?");
			viewProfile = con.prepareStatement("select * from users where username=?");
			lastloggedin = con.prepareStatement("update users set lastloggedin=current_timestamp"
					+ " where username=?");
			addProduct = con.prepareStatement("insert into product(productname, category, description, "
					+ "actualprice, quantity, image, sellerid) values(?,?,?,?,?,?,?)");
			displaySeller = con.prepareStatement("select name,email,phonenumber,lastloggedin from users where "
					+ "userid=?");
			findSellerId = con.prepareStatement("select productid from product where sellerid=? and productname=?");
			scheduleAuction = con.prepareStatement("insert into auction(minimumbidvalue, bidstart, bidend, productid) values(?,?,?,?)");
			updateStatusCompleted = con.prepareStatement("update auction set status=\"COMPLETED\" where bidend=?");
			displayAllProduct = con.prepareStatement("select productname from product where sellerid=?");
			getActualPrice = con.prepareStatement("select actualprice from product where sellerid=? and productname=?");
			displaySellerProducts = con.prepareStatement("select product.productname, max(bid.bidvalue),count(bid.userid),auction.bidend from "
					+ "auction left join product on product.productid=auction.productid left join bid on bid.productid=auction.productid where "
					+ "auction.status=\"OPEN\" and product.sellerid=? group by product.productid;");
			homePageDisplay = con.prepareStatement(" select product.productname,product.actualprice,product.image,auction.minimumbidvalue,auction.bidstart,auction.bidend from auction inner join product on product.productid=auction.productid where auction.status=\"OPEN\"");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Register User
	public int registerUser(User object) throws UserAlreadyExistsException{
		int result = 0;
		try {
			viewProfile.setString(1, object.getUserName());
			ResultSet res = viewProfile.executeQuery();
			// java.util.Date date=new java.util.Date();   
			if(res.next()) {
				throw new UserAlreadyExistsException("Username already exists!");
			}
			// Set all parameters
			register.setString(1, object.getName());
			register.setDate(2, object.getDateOfBirth());
			register.setString(3, object.getEmail());
			register.setString(4, object.getPhoneNumber());
			register.setString(5, object.getUserName());
			register.setString(6, object.getPassword());
			register.setString(7, object.getAddress());
			register.setString(8, object.getTypeOfUser());
			register.setDouble(9, object.getWalletAmount());
			result = register.executeUpdate();
			}
		catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	// Login User
	// Remaining: throw user not found exception
	public User loginUser(User object) throws IncorrectCredentialsException {
		User result = null;
		try {
			login.setString(1, object.getUserName());
			login.setString(2, object.getPassword());
			// Execute query
			ResultSet res = login.executeQuery();
			// java.util.Date date=new java.util.Date();   
			if(res.next()) {
				result = new User();
				lastloggedin.setString(1, object.getUserName());
				lastloggedin.executeUpdate();
				result.setTypeOfUser(res.getString(1));
				result.setUserid(res.getInt(2));
			}
			else {
				throw new IncorrectCredentialsException("Username or password is incorrect");
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	// Add product
	public int addProduct(Product object) {
		int result = 0;
		try {
			addProduct.setString(1, object.getProductname());
			addProduct.setString(2, object.getCategory());
			addProduct.setString(3, object.getDescription());
			addProduct.setDouble(4, object.getActualprice());
			addProduct.setInt(5, object.getQuantity());
			addProduct.setString(6, object.getImage());
			// SellerID from session
			addProduct.setInt(7, object.getSellerid());
			// Execute Query
			result = addProduct.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	// Display seller information
	public User displaySeller(User obj) {
		User temp = null;
		try {
		displaySeller.setInt(1, obj.getUserid());
		ResultSet res = displaySeller.executeQuery();
		if(res.next()) {
			temp = new User();
			temp.setName(res.getString(1));
			temp.setEmail(res.getString(2));
			temp.setPhoneNumber(res.getString(3));
			temp.setLastloggedin(res.getTimestamp(4));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return temp;
	}
	
	public int scheduleAuction(Auction auctionobject, User object) throws ActualGreaterThanMinimum {
		int result = 0;
		Product temp = new Product();
		try {
			getActualPrice.setInt(1, object.getUserid());
			getActualPrice.setString(2, auctionobject.getProductname());
			ResultSet res = getActualPrice.executeQuery();
			if(res.next()) {
				temp.setActualprice(res.getDouble(1));
			}
			// Check if price is higher
			if(temp.getActualprice()<auctionobject.getMinimumbid()) {
				throw new ActualGreaterThanMinimum("Minimum bid price cannot be greater than actual price");
			}
			else {
			scheduleAuction.setDouble(1, auctionobject.getMinimumbid());
			scheduleAuction.setDate(2, auctionobject.getBidstart());
			scheduleAuction.setDate(3, auctionobject.getBidend());
			scheduleAuction.setString(4, auctionobject.getProductname());
			result = scheduleAuction.executeUpdate();
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	// Background task
	public void backgroundTask() {
		Date utilDate = null;
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try {
			System.out.println(sqlDate);
			updateStatusCompleted.setDate(1, sqlDate);
			updateStatusCompleted.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Display Seller Products Information
	public OpenProducts displaysellerproduct(User object) {
		OpenProducts op = new OpenProducts();
		try {
			displaySellerProducts.setInt(1, object.getUserid());
			ResultSet res = displaySellerProducts.executeQuery();
			if(res.next()) {
				op.setProductName(res.getString(1));
				op.setMinBid(res.getDouble(2));
				op.setNoOfBiders(res.getInt(3));
				op.setBidDate((res.getTimestamp(4).toLocalDateTime()));
				}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return op;	
	}

	public List<Product> displayallProduct(User object) {
		List<Product> result = new ArrayList<Product>();
		// System.out.println("Hello");
		// System.out.println(object.getUserid());
		try {
			displayAllProduct.setInt(1, object.getUserid());
			ResultSet res = displayAllProduct.executeQuery();
			while(res.next()) {
				Product temp = new Product();
				temp.setProductname(res.getString(1));
				result.add(temp);
				System.out.println("Product added");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OpenProducts> homepageDisplayAll() {
		List<OpenProducts> result = new ArrayList<OpenProducts>();
		try {
			ResultSet res = homePageDisplay.executeQuery();
			while(res.next()) {
				OpenProducts temp = new OpenProducts();
				temp.setProductName(res.getString(1));
				temp.setActualPrice(res.getDouble(2));
				temp.setProductimage(res.getString(3));
				temp.setMinBid(res.getDouble(4));
				temp.setBidDate(res.getTimestamp(5).toLocalDateTime());
				temp.setBidEnd(res.getTimestamp(6).toLocalDateTime());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}