package com.jwt.hibernate.controller.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.dao.MitarbeiterDAO;

public class EasyCMAddMaCmd extends AbstractEasyCMCmdServlet implements EasyCMServletCmdIF {

	public EasyCMAddMaCmd(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {
		super(servlet, request, response);
	}

	@Override
	public void execute() throws Exception {
		
		
		String name = request.getParameter("name");
		String vorName = request.getParameter("vorname");;
		String telnr = request.getParameter("telnr");
		String adresse = request.getParameter("adresse");

		HttpSession session = request.getSession(true);
		try {
			MitarbeiterDAO maDAO = new MitarbeiterDAO();
			maDAO.storeMA(name, vorName, telnr, adresse);
			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}
}