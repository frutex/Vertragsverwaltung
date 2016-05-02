package com.jwt.hibernate.controller.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractEasyCMCmdServlet implements EasyCMServletCmdIF {

	private HttpServlet servlet;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public AbstractEasyCMCmdServlet(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.servlet = servlet;
		this.response = response;

	}

}
