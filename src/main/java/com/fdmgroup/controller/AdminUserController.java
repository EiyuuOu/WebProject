package com.fdmgroup.controller;

import java.io.IOException;

import javax.persistence.NoResultException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.AdminDaoImpl;
import com.fdmgroup.dao.AdminUserDao;
import com.fdmgroup.model.Users;

/**
 * Servlet implementation class AdminUserController
 */
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminUserDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserController() {
        super();
        this.dao = new AdminDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageuser.jsp").forward(request, response);
//		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/adminpageuser.jsp");
//		dispatch.forward(request, response);
		//response.sendRedirect("/WEB-INF/admin/adminpanel.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String balance = request.getParameter("balance");
		try {
			double balance1 = Double.valueOf(balance);
			Users user = dao.getUser(email);
			int userId = user.getId();
			dao.changeBalance(userId, balance1);
			request.getSession().setAttribute("success", "<font color=#006600>Balance change successful!</font>");
			getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageuser.jsp").forward(request, response);
			  
			} catch (NumberFormatException e) {
				request.getSession().setAttribute("double", "<font color=#990000>Thats not a Number</font>");
				getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageuser.jsp").forward(request, response);
			} catch (NoResultException e) {
				request.getSession().setAttribute("email", "<font color=#990000>Thats not a valid Email</font>");
				getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageuser.jsp").forward(request, response);
				
			}
		
		

		
	}

}
