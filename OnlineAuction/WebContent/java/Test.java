package com.hsbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Test extends HttpServlet {

  
	@Override
	protected void doPOST(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("username");
		 System.out.println("username: " + name);
	       // System.out.println("password: " + password);
	 
	        // do some processing here...
	         
	        // get response writer
	        PrintWriter writer = response.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Your username is: " + name + "<br/>";      
	     
	        htmlRespone += "</html>";
	         
	        // return response
	        writer.println(htmlRespone);
	}

}
