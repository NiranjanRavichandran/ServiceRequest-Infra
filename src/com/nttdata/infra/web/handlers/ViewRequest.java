package com.nttdata.infra.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.infra.dao.InfraAppException;
import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.service.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;

public class ViewRequest implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger("ViewRequest.java");

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int req = Integer.parseInt(request.getParameter("reqId"));
		// System.out.println(req);
		RequestDispatcher dispatch = null;
		InfraSystemFacade fac = new InfraSystemFacade();
		RequestDetails details = null;
		HttpSession session = request.getSession();
		try {
			details = fac.getSRDetails(req);
			session.setAttribute("srDetails", details);
			dispatch = request.getRequestDispatcher("RequestDetails.jsp");
			dispatch.forward(request, response);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			request.setAttribute("message", "Please try again after some time!");
			dispatch = request.getRequestDispatcher("ErrorPage.jsp");
			dispatch.forward(request, response);
		}

	}

}
