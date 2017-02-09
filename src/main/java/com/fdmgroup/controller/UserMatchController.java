package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.dao.UserMatchDao;
import com.fdmgroup.model.Match;
import com.fdmgroup.model.Player;
import com.fdmgroup.model.Users;

/**
 * Servlet implementation class UserMatchController
 */
public class UserMatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserMatchDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMatchController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new UserDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Match> matchList = dao.getAllMatches();

		
		request.getSession().setAttribute("matchListe", matchList);
		request.getRequestDispatcher("upcomingmatches.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String player = request.getParameter("player");
		int id = (int) session.getAttribute("id");
		
		try{
			String id2 = request.getParameter("matchId");
			int id1 = Integer.valueOf(id2);
			String amount1 = request.getParameter("amount");
			double amount = Double.valueOf(amount1);
//			double betReturn = dao.makeBet(id, player, amount);
//			dao.userBalanceChange(id, betReturn);
//			
		} catch (NumberFormatException e){
			request.getSession().setAttribute("betError", "<font color=#990000>Input Numbers please</font>");
			response.sendRedirect("upcomingmatches.jsp");
		}
		
	}

}
