package com.nttdata.infra.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.infra.dao.InfraAppException;
import com.nttdata.infra.domain.User;
import com.nttdata.infra.service.InfraSystemFacade;
import com.nttdata.mvc.HttpRequestHandler;

public class Login implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger("Login.java");

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userName = Integer.parseInt(request.getParameter("uname"));
		String password = request.getParameter("pass");
		HttpSession session = request.getSession();
		session.setAttribute("uID", userName);
		RequestDispatcher dispatch = null;
		InfraSystemFacade infra = new InfraSystemFacade();
		User login = new User();

		try {
			login = infra.userValidate(userName, password);
			LOG.info("returned login object" + login);
			// System.out.println(login);
			if (login == null) {
				LOG.debug("invalid login");
				request.setAttribute("validated", false);
				dispatch = request.getRequestDispatcher("/Pages/Login.jsp");
				dispatch.forward(request, response);
			} else {
				LOG.debug("Valid Login");
				request.setAttribute("validated", true);
				int roleId = login.getRollId();
				session.setAttribute("user", login);
				session.setAttribute("roleID", roleId);
				dispatch = request.getRequestDispatcher("/Pages/Menu.jsp");
				dispatch.forward(request, response);
			}
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
