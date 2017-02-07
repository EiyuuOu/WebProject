package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.model.Roles;
import com.fdmgroup.model.Users;

/**
 * Servlet implementation class RegistrationController
 * 
 * 
 * 
 * 
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
		this.dao = new UserDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// User Registration
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String balance = request.getParameter("balance");
		double balance1 = Double.valueOf(balance);
		
		
		/**
		 * Todo: Use Digest to encrypt passwords password 1 equals pw 2 email
		 */

		//Admin Email
		String email3 = "Niko@bla.de";
		try{
				
		Users user1 = dao.getUser(email);
		String email2 = user1.getEmail();
		
		if (email.equals(email2)) {
			
			request.getSession().setAttribute("str1", "<font color=#990000>Email already exists</font>");
			response.sendRedirect("signup.jsp");
			//getServletContext().getRequestDispatcher("/loginerror.jsp").forward(request, response);
		} 
		
		
		} catch (NoResultException e){
			
			if (!password.equals(password2)) {
				
				
				request.getSession().setAttribute("str2", "<font color=#990000>Password and Verify Password didnt match</font>");
				response.sendRedirect("signup.jsp");
				//getServletContext().getRequestDispatcher("/loginerror.jsp").forward(request, response);
			} 
			
			else{
				Users user = new Users(firstname, lastname, username, password, email, balance1);
				
				if(email.contains(email3)){
					user.setRole(Roles.ADMIN);
				}
				
				dao.newUser(user);
				
				
				
				request.getSession().setAttribute("str4","Hi "+ user.getFirstname()+" ! <br> Welcome to the team!");
				getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}
			
			
		}

		
			
	
	}
}
