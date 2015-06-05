package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.DAO.FilmDAO;
import be.vdab.DAO.GenreDAO;

/**
 * Servlet implementation class ReservatiesGenreFilmsServlet
 */
@WebServlet("/reservaties/films.htm")
public class ReservatiesGenreFilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/reservatiesgenrefilms.jsp";
	private static final transient GenreDAO genreDAO = new GenreDAO();
	private static final transient FilmDAO filmDAO = new FilmDAO();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("films", filmDAO.findFilmsByGenre(Integer.parseInt(request.getParameter("id"))));	
		
		request.setAttribute("genres", genreDAO.findAllGenres());		
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	
	@Resource(name = FilmDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		filmDAO.setDataSource(dataSource);
		genreDAO.setDataSource(dataSource);
	}	
	

}
