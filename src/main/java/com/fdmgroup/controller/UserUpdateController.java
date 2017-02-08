package com.fdmgroup.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.model.Users;

/**
 * Servlet implementation class UserUpdateController
 */
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateController() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new UserDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("userupdate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String option = request.getParameter("option");

		int id = (int) session.getAttribute("id");	

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		
		Users user = new Users(firstname, lastname, username, "password", email, 300);
		
		if(option.equals("Update")){
			
			dao.updateUser(id, user);
			request.getSession().setAttribute("updated", "<font color=#006600>Your data was Updated!</font>");
			getServletContext().getRequestDispatcher("userupdate.jsp").forward(request, response);
		} 
		else if (option.equals("Delete")){
			dao.deleteUser(id);
			request.getSession().setAttribute("deleted", "<font color=#990000>You were deleted!</font>");
			getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
