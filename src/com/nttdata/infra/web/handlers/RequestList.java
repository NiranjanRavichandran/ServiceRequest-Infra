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
import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.domain.RequestType;
import com.nttdata.infra.service.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;

public class RequestList implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger("RequestList.java");

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		InfraSystemFacade fac = new InfraSystemFacade();
		HttpSession session = request.getSession();
		int role = (Integer) session.getAttribute("roleID");
		RequestDispatcher dispatch = null;
		// Map<Integer, String> typeMap = new TreeMap<Integer, String>();
		List<RequestType> types = new ArrayList<RequestType>();
		try {
			LOG.info("Displaying ll requests");
			types = fac.getRequestTypes();
			// Iterator<RequestType> itr = types.iterator();
			// while (itr.hasNext()) {
			// RequestType typObj = new RequestType();
			// typObj = itr.next();
			// typeMap.put(typObj.getId(), typObj.getDesc());
			// }
			// request.setAttribute("typesMap", typeMap);
		} catch (InfraAppException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			LOG.error(e1.fillInStackTrace());
			request.setAttribute("message", "Please try again after some time!");
			dispatch = request.getRequestDispatcher("ErrorPage.jsp");
			dispatch.forward(request, response);
		}
		if (role == 1) {
			List<RequestDetails> reqList = new ArrayList<RequestDetails>();
			try {
				reqList = fac.getAllRequests();
				request.setAttribute("allReq", reqList);
				dispatch = request
						.getRequestDispatcher("/Pages/RequestLists.jsp");
				dispatch.forward(request, response);
			} catch (InfraAppException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				LOG.error(e.fillInStackTrace());
				request.setAttribute("message",
						"Please try again after some time!");
				dispatch = request.getRequestDispatcher("ErrorPage.jsp");
				dispatch.forward(request, response);
			}
		} else {
			List<RequestDetails> reqList = new ArrayList<RequestDetails>();
			int userId = (Integer) session.getAttribute("uID");
			try {
				reqList = fac.getRequestByCreator(userId);
				request.setAttribute("userReq", reqList);
				dispatch = request
						.getRequestDispatcher("/Pages/RequestLists.jsp");
				dispatch.forward(request, response);
			} catch (InfraAppException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				LOG.error(e.fillInStackTrace());
				request.setAttribute("message",
						"Please try again after some time!");
				dispatch = request.getRequestDispatcher("ErrorPage.jsp");
				dispatch.forward(request, response);
			}
		}
	}
}
