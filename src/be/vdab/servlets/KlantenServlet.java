package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.DAO.KlantDAO;

/**
 * Servlet implementation class KlantenServlet
 */
@WebServlet("/klant.htm")
public class KlantenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/klanten.jsp";
	private static final transient KlantDAO klantDAO = new KlantDAO();	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getQueryString() != null) {			
			String naam = request.getParameter("zoekKlant");
			if (!naam.isEmpty()) { 				
				request.setAttribute("klanten", klantDAO.zoekKlant(naam));
			} else {
				request.setAttribute("fout", "Tik minstens 1 letter");
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

		
	@Resource(name = KlantDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantDAO.setDataSource(dataSource);
	}

}
