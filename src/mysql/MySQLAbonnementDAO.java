package mysql;

import pojo.Abonnement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.AbonnementDAO;

public class MySQLAbonnementDAO implements AbonnementDAO {
	
	private static MySQLAbonnementDAO instance;
	
	private MySQLAbonnementDAO() {
		
	}

	public static MySQLAbonnementDAO getInstance() {
		if(instance == null) {
			instance = new MySQLAbonnementDAO();
		}
		return instance;
	}

	@Override
	public Abonnement getById(int id) {
		return null;
	}
	
	@Override
	public Abonnement getById(int id_client, int id_revue) {
		try {
			String sql = "SELECT * FROM Abonnement WHERE id_client = ? AND id_revue = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, id_client);
			request.setInt(2, id_revue);
			
			ResultSet result = request.executeQuery();
			
			if(result.next()) {
				return new Abonnement(id_client, id_revue, result.getString("date_debut"), result.getString("date_fin"));
			}
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur selection Abonnement : " + error.getMessage());
		}
		return null;
	}

	@Override
	public void create(Abonnement objet) {
		try {
			String sql = "INSERT INTO Abonnement (id_client, id_revue, date_debut, date_fin) VALUES (?, ?, ?, ?)";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, objet.getId_client());
			request.setInt(2, objet.getId_revue());
			request.setString(3, objet.getDate_deb());
			request.setString(4, objet.getDate_fin());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch (SQLException error) {
			System.out.println("Erreur création Abonnement : " + error.getMessage());
		}
	}

	@Override
	public void update(Abonnement objet) {
		try {
			String sql = "UPDATE Abonnement SET date_debut = ?, date_fin = ? WHERE id_client = ? AND id_revue = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setString(1, objet.getDate_deb());
			request.setString(2, objet.getDate_fin());
			request.setInt(3, objet.getId_client());
			request.setInt(4, objet.getId_revue());
	
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur modification Abonnement : " + error.getMessage());
		}
	}

	@Override
	public void delete(Abonnement objet) {
		try {
			String sql = "DELETE FROM Abonnement WHERE id_client = ? AND id_revue = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, objet.getId_client());
			request.setInt(2, objet.getId_revue());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur suppression Abonnement : " + error.getMessage());
		}
	}

	@Override
	public List<Abonnement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}