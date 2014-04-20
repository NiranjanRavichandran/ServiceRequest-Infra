package com.nttdata.infra.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.infra.dao.InfraAppException;
import com.nttdata.infra.domain.RequestType;
import com.nttdata.infra.service.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;

public class ReqType implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger("ReqType.java");

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RequestDispatcher dispatch = null;
		InfraSystemFacade infra = new InfraSystemFacade();
		List<RequestType> typeList = new ArrayList<RequestType>();

		try {
			LOG.info("Getting request types");
			typeList = infra.getRequestTypes();
			session.setAttribute("reqTypes", typeList);
			dispatch = request.getRequestDispatcher("/Pages/CreateRequest.jsp");
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
