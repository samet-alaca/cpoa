package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import pojo.Periodicite;

public class MySQLPeriodiciteDAO implements DAO<Periodicite> {
	
	private static MySQLPeriodiciteDAO instance;
	
	private MySQLPeriodiciteDAO() {
		
	}

	public static MySQLPeriodiciteDAO getInstance() {
		if(instance == null) {
			instance = new MySQLPeriodiciteDAO();
		}
		return instance;
	}
	
	public List<Periodicite> getAll() {
		try {
			String sql = "SELECT * FROM Periodicite";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			List<Periodicite> l = new ArrayList<Periodicite>();
			
			ResultSet result = request.executeQuery();
			
			while(result.next()) {
				l.add(new Periodicite(result.getInt("id_periodicite"), result.getString("libelle")));
			}
			
			if(request != null) {
				request.close();
			}
			
			return l;
		} catch(SQLException error) {
			System.out.println("Erreur selection du tout Périodicité : " + error);
		}
		return null;
	}

	@Override
	public Periodicite getById(int id) {
		try {
			String sql = "SELECT * FROM Periodicite WHERE id_periodicite = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, id);
			
			ResultSet result = request.executeQuery();
			
			if(result.next()) {
				return new Periodicite(id, result.getString("libelle"));
			}
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur selection Périodicité : " + error.getMessage());
		}
		return null;
	}

	@Override
	public void create(Periodicite objet) {
		try {
			String sql = "INSERT INTO Periodicite (libelle) values (?)";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setString(1, objet.getLibelle());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch (SQLException error) {
			System.out.println("Erreur création Périodicité : " + error.getMessage());
		}
	}

	@Override
	public void update(Periodicite objet) {
		try {
			String sql = "UPDATE Periodicite SET libelle = ? WHERE id_periodicite = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setString(1, objet.getLibelle());
			request.setInt(2, objet.getId());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur modification Périodicité : " + error.getMessage());
		}
	}

	@Override
	public void delete(Periodicite objet) {
		try {
			String sql = "DELETE FROM Periodicite WHERE id_periodicite = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, objet.getId());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur suppression Périodicité : " + error.getMessage());
		}
	}
}