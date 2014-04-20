package com.nttdata.infra.web.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.mvc.HttpRequestHandler;

public class Logout implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger("Logout.java");

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Logging out...");
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("Login.jsp");

	}

}
