package com.fdmgroup.controller;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.AdminDaoImpl;
import com.fdmgroup.dao.AdminPlayerDao;
import com.fdmgroup.model.Player;
import com.fdmgroup.model.Race;

/**
 * Servlet implementation class AdminPlayerUpdateController
 */
public class AdminPlayerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminPlayerDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPlayerUpdateController() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new AdminDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayerupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
		String option = request.getParameter("option1");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String username = request.getParameter("username");
		String team = request.getParameter("team");
		String nationality = request.getParameter("nationality");
		String race1 = request.getParameter("race").toUpperCase();
		Race race = Race.valueOf(race1);
		
		try{
			Player player = dao.getPlayer(username);
			String age1 = request.getParameter("age");
			int age = Integer.valueOf(age1);
			int id = player.getId();
			if(option.equals("Update")){
				Player player1 = new Player(firstname, lastname, age, username, team, nationality, race);
				dao.updatePlayer(id, player1);
				
				request.getSession().setAttribute("playerupdated", "<font color=#006600>Player data was updated!</font>");
				getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayerupdate.jsp").forward(request, response);
			}
			else if (option.equals("Delete")){
				dao.deletePlayer(id);
				request.getSession().setAttribute("playerdeleted", "<font color=#990000>Player deleted!</font>");
				getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayerupdate.jsp").forward(request, response);
			}
			
			
		} catch (NoResultException e){
			request.getSession().setAttribute("noUsername", "<font color=#990000>Username not found</font>");
			response.sendRedirect("/adminpageplayerupdate.jsp");
		} catch (NumberFormatException e){
			request.getSession().setAttribute("ageNumber1", "<font color=#990000>Age is not a number</font>");
			getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayerupdate.jsp").forward(request, response);
		}
		
	}

}
