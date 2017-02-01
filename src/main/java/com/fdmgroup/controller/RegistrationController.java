package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.model.Users;

/**
 * Servlet implementation class RegistrationController
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("signup.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//User Registration
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
		 * Todo: Use Digest to encrypt passwords
		 * password 1 equals pw 2
		 * email unique check
		 * 
		 * Loginpage -> Success
		 * 			 -> error
		 */
		
		
		
		Users user = new Users(firstname, lastname, username, password, email, balance1); 
		dao.newUser(user);
		
		out.println("<h1>Thanks for registering!</h1>");
		
	}

}
