package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.AdminDaoImpl;
import com.fdmgroup.dao.AdminPlayerDao;
import com.fdmgroup.model.Player;

/**
 * Servlet implementation class AdminPlayerListController
 */
public class AdminPlayerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminPlayerDao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPlayerListController() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new AdminDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		
		List<Player> playerList = dao.getAllPlayer();

		
		request.getSession().setAttribute("liste", playerList);
		request.getRequestDispatcher("/WEB-INF/admin/adminpageplayerlist.jsp").forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/admin/adminpageplayerlist.jsp").forward(request, response);
	}

}
