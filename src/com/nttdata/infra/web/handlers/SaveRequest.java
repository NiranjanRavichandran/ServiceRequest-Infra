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

public class SaveRequest implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger("SaveRequest.java");

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatch = null;
		java.util.Date date = new java.util.Date();
		Date today = new Date(date.getTime());
		HttpSession session = request.getSession();
		InfraSystemFacade infra = new InfraSystemFacade();
		RequestDetails updateReq = new RequestDetails();
		updateReq = (RequestDetails) session.getAttribute("srDetails");
		String rejectReason = request.getParameter("rejection");
		String cancelReason = request.getParameter("cancellation");
		int statusID = Integer.parseInt(request.getParameter("newStatus"));
		boolean updated;
		int roleId = (Integer) session.getAttribute("roleID");
		LOG.info("RoleId " + roleId);
		if (roleId == 1) {
			if (updateReq.getStatusID() != statusID) {
				if (updateReq.getStatusID() != 2
						&& updateReq.getStatusID() != 4
						&& updateReq.getStatusID() != 5) {

					// System.out.println(statusID);
					if (statusID == 3) {
						updateReq.setAssigndeDate(today);
						updateReq.setCommittedDate(today);
						updateReq.setRejectionReason("");
					} else if (statusID == 4) {
						updateReq.setCompletedDate(today);
					} else if (statusID == 5) {
						updateReq.setRejectionReason(rejectReason);
					}
					updateReq.setStatusID(statusID);
					try {
						updated = infra.saveSRDetails(updateReq);
						// System.out.println(updated);
						if (updated) {
							LOG.info("Update Successfull");
							request.setAttribute("updation", 1);
							request.setAttribute("updatedReq", updateReq);
							request.setAttribute("updateSuccess",
									"Updated successfully!");
							dispatch = request
									.getRequestDispatcher("Success.jsp");
							dispatch.forward(request, response);
						}
					} catch (InfraAppException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						LOG.error(e.fillInStackTrace());
						request.setAttribute("message",
								"Please try again after some time!");
						dispatch = request
								.getRequestDispatcher("ErrorPage.jsp");
						dispatch.forward(request, response);
					}
				} else {
					request.setAttribute("updateFail",
							"Cannot update a Cancelled/Completed/Rejected request!");
					dispatch = request.getRequestDispatcher("Update.jsp");
					dispatch.forward(request, response);
				}
			} else {
				request.setAttribute("updateFail", "Update Failed!");
				dispatch = request.getRequestDispatcher("Update.jsp");
				dispatch.forward(request, response);
			}
		} else if (roleId == 2) {
			// ----for user----
			// System.out.println("inside role 2");
			if (updateReq.getStatusID() != statusID) {
				if (updateReq.getStatusID() != 4
						&& updateReq.getStatusID() != 5) {
					updateReq.setStatusID(statusID);
					updateReq.setCancellationReason(cancelReason);
					try {
						updated = infra.saveSRDetails(updateReq);
						if (updated) {
							request.setAttribute("updation", 1);
							request.setAttribute("updatedReq", updateReq);
							request.setAttribute("updateSuccess",
									"Updated successfully!");
							dispatch = request
									.getRequestDispatcher("Success.jsp");
							dispatch.forward(request, response);
						}
					} catch (InfraAppException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						LOG.error(e.fillInStackTrace());
						request.setAttribute("message",
								"Please try again after some time!");
						dispatch = request
								.getRequestDispatcher("ErrorPage.jsp");
						dispatch.forward(request, response);
					}
				} else {
					request.setAttribute("updateFail",
							"Cannot cancel a Completed/Rejected request");
					dispatch = request.getRequestDispatcher("Update.jsp");
					dispatch.forward(request, response);
				}
			}
		}
	}
}
