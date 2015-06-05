package be.vdab.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Klant;

public class KlantDAO extends AbstractDAO{

	private static final String SELECT_KLANTEN = "select id, familienaam, voornaam, straatNummer,postcode,gemeente from klanten where familienaam like ?";
	private static final String SELECT_NAAM ="select voornaam,familienaam from klanten where id=?";
	private final static Logger logger = Logger.getLogger(FilmDAO.class.getName());

	
	public Set<Klant> zoekKlant(String naam){
		Set<Klant> klanten = new HashSet<>();
		try(Connection connection = dataSource.getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_KLANTEN)){
			StringBuilder familienaam = new StringBuilder();
			familienaam.append("%");
			familienaam.append(naam);
			familienaam.append("%");
			statement.setString(1, familienaam.toString());
			try(ResultSet resultSet = statement.executeQuery()){
				while (resultSet.next()){
					klanten.add(new Klant(resultSet.getInt("id"),resultSet.getString("familienaam"),resultSet.getString("voornaam"),resultSet.getString("straatNummer"),resultSet.getString("postcode"),resultSet.getString("gemeente")));
				}
			}
			
		}catch (SQLException ex){
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
		return klanten;
	}
	
	public String getVolledigeNaam(int id){
		
		try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_NAAM)){
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()){
				if (resultSet.next()){
					return resultSet.getString("voornaam") + ' ' + resultSet.getString("familienaam"); 
				}
			}
			return "naam niet gevonden";
		}catch (SQLException ex){
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
		
	}
	
}
