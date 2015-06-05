package be.vdab.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Film;

public class FilmDAO extends AbstractDAO {

	private static final String SELECT_FILMS_GENRE = "select titel , id , voorraad ,  gereserveerd, prijs, (voorraad-gereserveerd) as beschikbaar from  films  where genreid=?";
	private static final String SELECT_VOORRAAD = "select id, voorraad, gereserveerd from films where gereserveerd<voorraad and id in (?)";

	private final static Logger logger = Logger.getLogger(FilmDAO.class
			.getName());


	public Set<Film> findFilmsByGenre(int id) {
		Set<Film> films = new HashSet<>();

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SELECT_FILMS_GENRE)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					films.add(new Film(resultSet.getInt("id"), resultSet
							.getString("titel"), resultSet.getInt("voorraad"),
							resultSet.getInt("gereserveerd"), resultSet
									.getBigDecimal("prijs"), resultSet
									.getInt("beschikbaar")));
				}
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
		return films;
	}

	public Set<Film> findFilmTitle(Set<Integer> mandje) {
		
		Set<Film> films = new HashSet<>();
		StringBuilder idFilmsInMandje = new StringBuilder();

		if (!mandje.isEmpty()) {
			for (int i = 0; i < mandje.size(); i++) {
				idFilmsInMandje.append("?,");
			}

			idFilmsInMandje.deleteCharAt((idFilmsInMandje.length() - 1));
			idFilmsInMandje.append(")");

			String SELECT_FILM = "select id, titel, voorraad, gereserveerd,prijs, (voorraad-gereserveerd) as beschikbaar from films where id in("
					+ idFilmsInMandje.toString();

			try (Connection connection = dataSource.getConnection();
					PreparedStatement statement = connection
							.prepareStatement(SELECT_FILM)) {

				int teller = 1;
				for (int id : mandje) {
					statement.setInt(teller, id);
					teller++;

				}

				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {

						films.add(new Film(resultSet.getInt("id"), resultSet
								.getString("titel"), resultSet
								.getInt("voorraad"), resultSet
								.getInt("gereserveerd"), resultSet
								.getBigDecimal("prijs"), resultSet
								.getInt("beschikbaar")));						
					}

					return films;
				}
			} catch (SQLException ex) {
				logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
				throw new DAOException(ex);
			}
		} else {			
			return films;
		}

	}

	
	public String reserverenFilm(int filmId, int klantId) {
		String INSERT_SQL = "insert into reservaties values(?,?,?)";
		String UPDATE_SQL = "update films set gereserveerd = gereserveerd +1 where id =? and voorraad>gereserveerd";
		java.util.Date date = new Date();
		Object currentDate = new java.sql.Timestamp(date.getTime());

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statementSelect = connection
						.prepareStatement(SELECT_VOORRAAD);
				PreparedStatement statementInsert = connection
						.prepareStatement(INSERT_SQL);
				PreparedStatement statementUpdate = connection
						.prepareStatement(UPDATE_SQL)) {
			connection
					.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			connection.setAutoCommit(false);
			statementSelect.setInt(1, filmId);
			try (ResultSet resultSet = statementSelect.executeQuery()) {
				if (resultSet.next()) {
					statementInsert.setInt(1, klantId);
					statementInsert.setInt(2, filmId);
					statementInsert.setObject(3, currentDate);
					statementUpdate.setInt(1, filmId);
					statementInsert.executeUpdate();
					statementUpdate.executeUpdate();
					connection.commit();
					return "OK";
				} else {
					return "mislukt voor " + getTitelFilm(filmId);
				}
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}

	private String getTitelFilm(int id) {

		String SELECT_FILM_TITEL = "select titel from films where id=?";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SELECT_FILM_TITEL)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getString("titel");
				}
			}
			return "titel niet gevonden";

		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}

	}

	
	public Film findEnkeleFilmTitel(int id) {
		StringBuilder filmId = new StringBuilder();
		filmId.append("(?)");
		String SELECT_FILM = "select id, titel, voorraad, gereserveerd,prijs, (voorraad-gereserveerd) as beschikbaar from films where id in"
				+ filmId.toString();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SELECT_FILM)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Film(resultSet.getInt("id"),
							resultSet.getString("titel"),
							resultSet.getInt("voorraad"),
							resultSet.getInt("gereserveerd"),
							resultSet.getBigDecimal("prijs"),
							resultSet.getInt("beschikbaar"));
				}
			}
			return null;

		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}
}
