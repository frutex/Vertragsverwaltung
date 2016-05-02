package com.jwt.hibernate.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	protected void sendJsonResult(String jsonResult) throws IOException {
	    response.setContentType("application/json;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    if (null != jsonResult) {
	      PrintWriter writer = response.getWriter();
	      writer.print(jsonResult);
	      writer.close();
	    }
	  }

}
