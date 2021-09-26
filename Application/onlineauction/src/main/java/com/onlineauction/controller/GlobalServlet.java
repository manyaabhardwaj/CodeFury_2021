package com.onlineauction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auction.trial.Trial;
import com.onlineauction.exception.ActualGreaterThanMinimum;
import com.onlineauction.exception.IncorrectCredentialsException;
import com.onlineauction.exception.UserAlreadyExistsException;
import com.onlineauction.model.Auction;
import com.onlineauction.model.OpenProducts;
import com.onlineauction.model.Product;
import com.onlineauction.model.User;
import com.onlineauction.service.ServiceInterface;
import com.onlineauction.utility.ServiceFactory;

public class GlobalServlet extends HttpServlet {
	
	ServiceInterface serviceinterface;

	public GlobalServlet() {
		//System.out.println("Inside constructor");
		//Trial t = new Trial();
		//t.timer();
		// ServiceInterface point it to ServiceFactory
		serviceinterface = ServiceFactory.createServiceObject();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		String option=request.getParameter("ac");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// Register
		if(option.equalsIgnoreCase("register")) {
			String name=request.getParameter("name");
			String dateOfBirth = request.getParameter("dob");
			String email=request.getParameter("email");
			String phoneNumber = request.getParameter("phone");
			String userName = request.getParameter("username");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			String typeOfUser = request.getParameter("typeOfUser");
			System.out.println(typeOfUser);
			String wallet = request.getParameter("wallet");
		
			java.sql.Date dob = java.sql.Date.valueOf(dateOfBirth);
			double walletAmount = Double.parseDouble(wallet); 
			
			User object=new User();
			object.setName(name);
			object.setDateOfBirth(dob);
			object.setEmail(email);
			object.setPhoneNumber(phoneNumber);
			object.setUserName(userName);
			object.setPassword(password);
			object.setAddress(address);
			object.setTypeOfUser(typeOfUser);
			object.setWalletAmount(walletAmount);

			int result = 0;
			try {
				result = serviceinterface.register(object);
				if(result>0){
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
					rd.forward(request, response);
				}	
				else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Something went wrong');");
					out.println("location='index.html';");
					out.println("</script>");
				}
			} 
			catch (UserAlreadyExistsException e) {
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('User Already exists');");
				 out.println("location='index.html';");
				 out.println("</script>");
			}
		}
		
		// Login
		if(option.equalsIgnoreCase("login")) {
			// Get data from POST
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			// Create object
			User object = new User();
			object.setUserName(userName);
			object.setPassword(password);
			// Call service layer
			try {
				User result = serviceinterface.login(object);
				if(result != null) {
					// Set into session
					HttpSession session = request.getSession();
					session.setAttribute("user", result.getUserid());
					session.setAttribute("type", result.getTypeOfUser());
					String path ="/"+result.getTypeOfUser()+".jsp";
					RequestDispatcher rd=getServletContext().getRequestDispatcher(path);
					rd.forward(request, response);
				}
				else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Something went wrong');");
					out.println("location='login.html';");
					out.println("</script>");
				}
			} 
			catch (IncorrectCredentialsException e) {
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('Incorrect username or password');");
				 out.println("location='login.html';");
				 out.println("</script>");
			}
		}
		
		// Display All products on the homepage
		if(option.equalsIgnoreCase("homepageDisplayAllProducts")) {
			// Create an array of openproducts
			List<OpenProducts> result = new ArrayList<OpenProducts>();
			result = serviceinterface.homepageDisplayAllProducts();
			System.out.println("Now printing");
			if(result!=null) {
			for(OpenProducts temp: result) {
				System.out.println(temp.getProductName()+" "+temp.getActualPrice()+" "+temp.getProductimage()+" "+temp.getBidDate());
				}
			}
			else {
				System.out.println("Empty set");
			}
		}
		
		// Add product
		if(option.equalsIgnoreCase("addproduct")) {
			
			// Get id from session
			HttpSession session = request.getSession(false);
			Integer userid = (Integer) session.getAttribute("user");
			System.out.println(userid);
			
			String category = request.getParameter("category");
			String description = request.getParameter("description");
			String productname = request.getParameter("productname");
			String actualPrice = request.getParameter("price");
			String Quantity = request.getParameter("quantity");
			String image = request.getParameter("image");
				
			// Parse
			double actualprice = Double.parseDouble(actualPrice); 
			int quantity = Integer.parseInt(Quantity);
				
			// Add product
			Product object = new Product();
			object.setProductname(productname);
			object.setCategory(category);
			object.setDescription(description);
			object.setActualprice(actualprice);
			object.setQuantity(quantity);
			object.setSellerid(userid);
			// Figure out image again
			object.setImage(image);
				
			int result = serviceinterface.addProduct(object);
			if(result>0) {
				System.out.println("Inside if add product");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Product added');");
				out.println("location='Seller.jsp';");
				out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong');");
				out.println("location='Seller.jsp';");
				out.println("</script>");
			}
	}
		
		// Display seller information
		// This function should be called when the page loads
		if(option.equalsIgnoreCase("displayseller")){
			
			// System.out.println("Display seller");
			
			// Get id from session
			HttpSession session = request.getSession(false);
			Integer userid = (Integer) session.getAttribute("user");
			String type = (String)session.getAttribute("type");
			System.out.println(type);
			// System.out.println(userid);
			// Create data object
			User object = new User();
			object.setUserid(userid);
			User result = serviceinterface.displaySeller(object);
			if(result!=null) {
				// System.out.println(result.getName()+" "+result.getName()+" "+result.getPhoneNumber()+" "+result.getLastloggedin());
				request.setAttribute("object", result);
				request.setAttribute("session", session.getAttribute("type"));
				RequestDispatcher rd=getServletContext().getRequestDispatcher("Seller.jsp");
				rd.forward(request, response);
				}
			}
		
		// Products local to seller
		if(option.equalsIgnoreCase("displaysellerproduct")) {
			HttpSession session = request.getSession(false);
			int userid = (Integer) session.getAttribute("user");
			
			User object = new User();
			object.setUserid(userid);
			
			OpenProducts product = new OpenProducts();
			product = serviceinterface.displaySellerProduct(object);
			
			if(product!=null)
				System.out.println(product.getProductName()+" "+product.getMinBid()+" "+product.getNoOfBiders()+" "+product.getBidDate());
		}
		
		
		// Sub part of schedule auction 
		if(option.equalsIgnoreCase("LoadAllProducts")) {
			
			HttpSession session = request.getSession(false);
			int userid = (Integer) session.getAttribute("user");
			
			List<Product> result = new ArrayList<Product>();
			
			User object = new User();
			object.setUserid(userid);
			System.out.println(userid);
			result = serviceinterface.displayAllProduct(object);
		
			for(Product temp:result) {
				System.out.println(temp.getProductname());
			}
		
			if(result!=null) {
				request.setAttribute("availableProducts", result);
				request.setAttribute("session", session.getAttribute("type"));
				RequestDispatcher rd=getServletContext().getRequestDispatcher("Seller.jsp");
				rd.include(request, response);
			}
		}
		
		
		if(option.equalsIgnoreCase("scheduleauction")) {
			// System.out.println("Inside schedule now");
			HttpSession session = request.getSession(false);
			int userid = (Integer) session.getAttribute("user");
			// System.out.println(userid);
			
			String productname=request.getParameter("productname");
			String minbid = request.getParameter("minbid");
			String bidstart=request.getParameter("bidstart");
			String bidend = request.getParameter("bidend");
			
			// Parse
			double minBid = Double.parseDouble(minbid); 
			java.sql.Date bidStart = java.sql.Date.valueOf(bidstart);
			java.sql.Date bidEnd = java.sql.Date.valueOf(bidend);
			
			// Object and add
			
			User object = new User();
			object.setUserid(userid);
			
			Auction auctionobject = new Auction();
			auctionobject.setProductname(productname);
			auctionobject.setMinimumbid(minBid);
			auctionobject.setBidstart(bidStart);
			auctionobject.setBidend(bidEnd);
			
			// Pass to service
			try {
				int result = serviceinterface.scheduleAuction(auctionobject, object);
				if(result>0)
					System.out.println("Auction scheduled");
				else
					System.out.println("Oops!");
			}
			catch(ActualGreaterThanMinimum e) {
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('Minimum bid price cannot be greater than actual price');");
				 out.println("location='Seller.jsp';");
				 out.println("</script>");
			}
			
		}
	}
}