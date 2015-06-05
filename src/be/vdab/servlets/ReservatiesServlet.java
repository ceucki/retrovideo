package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.DAO.GenreDAO;

/**
 * Servlet implementation class ReservatiesServlet
 */
@WebServlet("/index.htm")
public class ReservatiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private static final transient GenreDAO genreDAO = new GenreDAO();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("genres", genreDAO.findAllGenres());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	

	@Resource(name = GenreDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
	genreDAO.setDataSource(dataSource);}
}
