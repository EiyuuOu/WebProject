package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.AdminDaoImpl;
import com.fdmgroup.dao.AdminMatchDao;
import com.fdmgroup.model.Match;
import com.fdmgroup.model.Matchwinner;

/**
 * Servlet implementation class AdminMatchController
 */
public class AdminMatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminMatchDao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMatchController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new AdminDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpagematches.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String player1 = request.getParameter("username1");
		String player2 = request.getParameter("username2");
		
		try{
			String rateOne = request.getParameter("rate1");
			String rateTwo = request.getParameter("rate2");
			double rate1 = Double.valueOf(rateOne);
			double rate2 = Double.valueOf(rateTwo);
			/*
			 * Set matchwinner here
			 */
			Matchwinner winner = Matchwinner.TBD;
			
			Match match = new Match(player1, player2, rate1, rate2, winner);
			
			dao.newMatch(match);
			out.print(match);
			request.getSession().setAttribute("matchAdded", "<font color=#006600>Match added!</font>");
			getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpagematches.jsp").forward(request, response);
			
		} catch(NumberFormatException e){
			request.getSession().setAttribute("rateNumber", "<font color=#990000>Rate is not a Number</font>");
			getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpagematches.jsp").forward(request, response);
		}
	}

}
