package be.vdab.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Genre;

public class GenreDAO extends AbstractDAO {
	private final static Logger logger = Logger.getLogger(FilmDAO.class
			.getName());
	private static final String SELECT_GENRES = "select id, naam from genres order by naam";

	public Set<Genre> findAllGenres() {
		
		Set<Genre> genres = new LinkedHashSet<>();
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_GENRES)) {
			while (resultSet.next()) {
				genres.add(new Genre(resultSet.getLong("id"), resultSet
						.getString("naam")));

			}

		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
		return genres;
	}

}
