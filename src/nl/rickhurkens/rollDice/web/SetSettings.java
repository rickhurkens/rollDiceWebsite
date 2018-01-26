package nl.rickhurkens.rollDice.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.rickhurkens.rollDice.dice.Cup;

/**
 * Servlet implementation class SetSettings
 */
public class SetSettings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int numberOfDice = Integer.parseInt(request.getParameter("diceAmount"));
		int numberOfEyes = Integer.parseInt(request.getParameter("eyesAmount"));
		
		session.setAttribute("numberOfDice", numberOfDice);
		session.setAttribute("numberOfEyes", numberOfEyes);
		session.setAttribute("cup", new Cup(numberOfDice,numberOfEyes));
		
		RequestDispatcher view = request.getRequestDispatcher("rollDice");
		view.forward(request, response);
	}

}