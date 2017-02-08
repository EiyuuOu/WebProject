package com.fdmgroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.AdminDaoImpl;
import com.fdmgroup.dao.AdminPlayerDao;
import com.fdmgroup.model.Player;
import com.fdmgroup.model.Race;

/**
 * Servlet implementation class AdminPlayerController
 */
public class AdminPlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminPlayerDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPlayerController() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new AdminDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String team = request.getParameter("team");
		String nationality = request.getParameter("nationality");
		String race1 = request.getParameter("race").toUpperCase();
		Race race = Race.valueOf(race1);
		
		
		
		try {
			String age1 = request.getParameter("age");
			int age = Integer.valueOf(age1);	
			
			Player player = new Player(firstname, lastname, age, username, team, nationality, race);
			dao.newPlayer(player);
			request.getSession().setAttribute("playeradded", "<font color=#006600>Player added!</font>");
			getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayer.jsp").forward(request, response);
			
		} catch (NumberFormatException e){
			request.getSession().setAttribute("ageNumber", "<font color=#990000>Age is not a number</font>");
			getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayer.jsp").forward(request, response);
		}
	}

}
