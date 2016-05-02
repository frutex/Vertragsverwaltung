package com.jwt.hibernate.controller.servlets;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.bean.MitarbeiterEO;
import com.jwt.hibernate.dao.MitarbeiterDAO;

public class EasyCMSearchCmd extends AbstractEasyCMCmdServlet implements EasyCMServletCmdIF {

	public EasyCMSearchCmd(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {
		super(servlet, request, response);
	}

	@Override
	public void execute() throws Exception {
		String id = "";
		String name = "";
		String tosearch = request.getParameter("search");

		try {
			if (Integer.parseInt(tosearch) % 1 == 0) {
				id = tosearch;
			}
		} catch (NumberFormatException e) {
			name = tosearch;
		}

		HttpSession session = request.getSession(true);
		try {
			MitarbeiterDAO maDAO = new MitarbeiterDAO();
			MitarbeiterEO tmp = maDAO.findMA(id, name);
			String rid = Integer.toString(tmp.getM_id());
			String rname = tmp.getM_name();
			String rvorname = tmp.getM_vorname();
			String rtelnr = tmp.getM_telnr();
			String radresse = tmp.getM_adresse();

			// create the Mitarbeiter EO
			MitarbeiterEO ma = new MitarbeiterEO(rname, rvorname, rtelnr, radresse);
			this.sendJsonResult(ma.toJSON());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}