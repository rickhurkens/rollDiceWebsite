package nl.rickhurkens.rollDice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.rickhurkens.rollDice.dice.Cup;

/**
 * Servlet implementation class RollDiceDispatcher
 */
/*@WebServlet(
		description = "handles http requests and forwards to JSPs", 
		urlPatterns = { "/rollDice" })*/
public class RollDiceDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		session = getSession(request);
		RequestDispatcher view = request.getRequestDispatcher("rollDice.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = getSession(request);
		
		if (request.getParameter("rollButton") != null) {
			((Cup)session.getAttribute("cup")).roll();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("rollDice.jsp");
		view.forward(request, response);
	}
	
	private HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		if (session.getAttribute("cup") == null) {
			int numberOfDice = Integer.parseInt(request.getServletContext().getInitParameter("numberOfDice"));
			int numberOfEyes = Integer.parseInt(request.getServletContext().getInitParameter("numberOfEyes"));
			
			session.setAttribute("numberOfDice", numberOfDice);
			session.setAttribute("numberOfEyes", numberOfEyes);
			session.setAttribute("cup", new Cup(numberOfDice,numberOfEyes));
		}
		return session;
	}
}
