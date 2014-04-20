package com.nttdata.infra.web.handlers;

import java.io.IOException;
import java.sql.Date;

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

public class CreateRequest implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger("CreateRequest.java");

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.info("invoking creat new SR handler");
		// TODO Auto-generated method stub
		InfraSystemFacade infra = new InfraSystemFacade();
		HttpSession session = request.getSession();
		int requestId = 0;
		RequestDispatcher dispatch = null;
		int userId = (Integer) session.getAttribute("uID");
		String location = request.getParameter("location");
		int cubeNo = Integer.parseInt(request.getParameter("cubicalNo"));
		String department = request.getParameter("department");
		String requiredByDate = request.getParameter("reqByDate");
		int typeId = Integer.parseInt(request.getParameter("reqType"));

		String justification = request.getParameter("just");
		int statusId = 1;

		java.util.Date date = new java.util.Date();
		Date today = new Date(date.getTime());
		RequestDetails createReq = new RequestDetails(userId, location, cubeNo,
				department, today, requiredByDate, typeId, justification,
				statusId);
		// sr1.setRequestedDate(today);
		createReq.setAssigndeDate(null);
		createReq.setCancellationReason(null);
		createReq.setCommittedDate(null);
		createReq.setCompletedDate(null);
		createReq.setRejectionReason(null);
		try {
			LOG.info("careated new SR");
			requestId = infra.createNewSR(createReq);
			request.setAttribute("createdReqId", requestId);
			dispatch = request.getRequestDispatcher("/Pages/Success.jsp");
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
