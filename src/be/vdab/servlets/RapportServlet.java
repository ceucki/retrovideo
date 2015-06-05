package be.vdab.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RapportServlet
 */
@WebServlet("/rapport.htm")
public class RapportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/rapport.jsp";
	private static final String RESERVATIERAPPORT = "gelukteMislukteReservaties";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			@SuppressWarnings("unchecked")
			Map<String, String> gelukteMislukteReservaties = (Map<String, String>) session
					.getAttribute(RESERVATIERAPPORT);
			Set<String> mislukteReservaties = new HashSet<>();
			for (Object entry : gelukteMislukteReservaties.values()) {
				if (!entry.equals("OK")) {
					mislukteReservaties.add((String) entry);
				}
			}
			if (mislukteReservaties.isEmpty()) {
				request.setAttribute("ReservatieGeluktMislukt", "OK");
			} else {
				request.setAttribute("ReservatieGeluktMislukt",
						mislukteReservaties);
			}

			session.invalidate();
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
