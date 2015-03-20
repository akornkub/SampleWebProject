package com.jas.myweb;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccumulateServlet
 */
@WebServlet(name = "Accumulate", urlPatterns = { "/Accumulate" })
public class AccumulateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccumulateServlet() {
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

		//HttpSession session = request.getSession();
		
		ServletContext context = request.getServletContext();

		//Integer total = (Integer) session.getAttribute("total");
		
		Integer total = (Integer) context.getAttribute("total");
		if (total == null) {
			total = 0;
		}
		
		String number = request.getParameter("number");
		
		if (number != null) {
			total += Integer.parseInt(number);
		}

		//session.setAttribute("total", total);
		
		context.setAttribute("total", total);

		request.getRequestDispatcher("/Accumulate.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
