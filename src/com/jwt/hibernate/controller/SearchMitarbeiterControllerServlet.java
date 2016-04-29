package com.jwt.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.bean.MitarbeiterEO;
import com.jwt.hibernate.dao.MitarbeiterDAO;

public class SearchMitarbeiterControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4903268020531412264L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String iD = request.getParameter("ID");
		String name = request.getParameter("name");


		HttpSession session = request.getSession(true);
		try {
			MitarbeiterDAO maDAO = new MitarbeiterDAO();
			MitarbeiterEO tmp=maDAO.findMA(iD, name);
			String rid = Integer.toString(tmp.getM_id());
			String rname = tmp.getM_name();
			String rvorname = tmp.getM_vorname();
			String rtelnr = tmp.getM_telnr();
			String radresse = tmp.getM_adresse();
			
			PrintWriter out = response.getWriter();

			 String docType =
				      "<!doctype html public \"-//w3c//dtd html 4.0 " +
				      "transitional//en\">\n";
				      out.println(docType +
				                "<html>\n" +
				                "<head><title>Search results </title></head>\n" +
				                "<body bgcolor=\"#f0f0f0\">\n" +
				                "<h1 align=\"center\"> Search Results </h1>\n" +
				                "<ul>\n" +
				                "  <li><b>ID:</b>: "
				                + rid + "\n" +
				                "  <li><b>Name</b>: "
				                + rname + "\n" +
				                "  <li><b>Vorname</b>: "
				                + rvorname + "\n"
				                +
				                "  <li><b>Telnr</b>: "
				                + rtelnr + "\n" 
				                +
				                "  <li><b>Adresse</b>: "
				                + radresse + "\n" +
				                "</ul>\n" +
				                "</body></html>");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req,res);
	}
}
