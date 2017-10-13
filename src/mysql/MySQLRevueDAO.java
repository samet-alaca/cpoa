package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.DAO;
import pojo.Revue;

public class MySQLRevueDAO implements DAO<Revue> {
	
	private static MySQLRevueDAO instance;
	
	private MySQLRevueDAO() {
		
	}

	public static MySQLRevueDAO getInstance() {
		if(instance == null) {
			instance = new MySQLRevueDAO();
		}
		return instance;
	}

	@Override
	public Revue getById(int id) {
		try {
			String sql = "SELECT * FROM Revue WHERE id_revue = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, id);
			
			ResultSet result = request.executeQuery();
			
			if(result.next()) {
				return new Revue(id,
					result.getString("titre"),
					result.getString("description"),
					result.getFloat("tarif_numero"),
					result.getString("visuel"),
					result.getInt("id_periodicite")
				);
			}
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur sélection Revue : " + error.getMessage());
		}
		return null;
	}

	@Override
	public void create(Revue objet) {
		try {
			String sql = "INSERT INTO Revue (titre, description, tarif_numero, visuel, id_periodicite) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setString(1, objet.getTitre());
			request.setString(2, objet.getDescription());
			request.setDouble(3, objet.getTarif_numero());
			request.setString(4, objet.getVisuel());
			request.setInt(5, objet.getId_revue());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch (SQLException error) {
			System.out.println("Erreur création Revue : " + error.getMessage());
		}
	}

	@Override
	public void update(Revue objet) {
		try {
			String sql = "UPDATE Revue SET titre = ?, description = ?, tarif_numero = ?, visuel = ?, id_periodicite = ? WHERE id_revue = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setString(1, objet.getTitre());
			request.setString(2, objet.getDescription());
			request.setDouble(3, objet.getTarif_numero());
			request.setString(4, objet.getVisuel());
			request.setInt(5, objet.getId_periodicite());
			request.setInt(6, objet.getId_revue());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur modification Revue : " + error.getMessage());
		}
	}

	@Override
	public void delete(Revue objet) {
		try {
			String sql = "DELETE FROM Revue WHERE id_revue = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, objet.getId_revue());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur suppression Revue : " + error.getMessage());
		}
	}

	@Override
	public List<Revue> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
