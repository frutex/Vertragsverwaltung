package com.jwt.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.dao.TestHibernateDB;


public class UserControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String vorName = request.getParameter("vorname");;
		String telnr = request.getParameter("telnr");
		String adresse = request.getParameter("adresse");

		HttpSession session = request.getSession(true);
		try {
			TestHibernateDB userDAO = new TestHibernateDB();
			userDAO.storeMA(name, vorName, telnr, adresse);
			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
