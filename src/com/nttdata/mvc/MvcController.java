package com.nttdata.mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MvcController
 */
public class MvcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map handlers;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MvcController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getServletPath();
		// System.out.println(url);
		String key = url.substring(7, url.lastIndexOf('.'));
		HttpRequestHandler handler = (HttpRequestHandler) handlers.get(key);
		if (handler != null) {
			handler.handle(request, response);
		} else {
			throw new ServletException("No matching handler!");
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String mvcProps = getServletContext().getRealPath(
				"/WEB-INF/mvc.properties");
		try {
			this.handlers = MvcUtil.buildHandlers(mvcProps);
		} catch (MVCException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new ServletException(e.getMessage());
		}

	}
}
