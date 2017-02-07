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
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new UserDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		
		try{	
		
		Users user = dao.getUser(email);
		if(!email.equals(user.getEmail()) || !password.equals(user.getPassword())){
			
			request.getSession().setAttribute("str6", "<font color=#990000>Email and/or Password didnt match</font>");
			response.sendRedirect("login.jsp");
			//getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		} 
		else if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
			request.getSession().setAttribute("user", user);
			
			
			if(user.getRole().equals(Roles.USER)){
				request.getSession().setAttribute("username", user.getUsername());
				request.getSession().setAttribute("balance", user.getBalance());
				request.getSession().setAttribute("str4"," <br> Welcome back "+user.getFirstname()+" ! ");
				request.getSession().setAttribute("id", user.getId());
				getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
				
			}
			if(user.getRole().equals(Roles.ADMIN)){
				request.getSession().setAttribute("str5", "<br> Welcome back Grandmaster "+user.getFirstname()+" !");
				getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpanel.jsp").forward(request, response);
				
			}
			
		}
		
		} catch (NoResultException e){
			request.getSession().setAttribute("str6", "<font color=#990000>Email and/or Password didnt match</font>");
			response.sendRedirect("login.jsp");
			//getServletContext().getRequestDispatcher("/loginerror.jsp").forward(request, response);
			
		}
	}

}
