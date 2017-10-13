package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.DAO;
import pojo.Client;

public class MySQLClientDAO implements DAO<Client> {
	
	private static MySQLClientDAO instance;
	
	private MySQLClientDAO() {
		
	}

	public static MySQLClientDAO getInstance() {
		if(instance == null) {
			instance = new MySQLClientDAO();
		}
		return instance;
	}
	
	@Override
	public Client getById(int id) {
		try {
			String sql = "SELECT * FROM Client WHERE id_client = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, id);
			
			ResultSet result = request.executeQuery();
			
			if(result.next()) {
				return new Client(
					id,
					result.getString("nom"),
					result.getString("prenom"),
					result.getString("no_rue"),
					result.getString("voie"),
					result.getString("code_postal"),
					result.getString("ville"),
					result.getString("pays")
				);
			}
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur selection Client : " + error.getMessage());
		}
		return null;
	}

	@Override
	public void create(Client objet) {
		try {
			String sql = "INSERT INTO Client (nom, prenom, no_rue, voie, code_postal, ville, pays) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setString(1, objet.getNom());
			request.setString(2, objet.getPrenom());
			request.setString(3, objet.getNo_rue());
			request.setString(4, objet.getVoie());
			request.setString(5, objet.getCode_postal());
			request.setString(6, objet.getVille());
			request.setString(7, objet.getPays());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur création Client : " + error.getMessage());
		}
	}

	@Override
	public void update(Client objet) {
		try {
			String sql = "UPDATE Client SET nom = ?, prenom = ?, no_rue = ?, voie = ?, code_postal = ?, ville = ?, pays = ? WHERE id_client = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setString(1, objet.getNom());
			request.setString(2, objet.getPrenom());
			request.setString(3, objet.getNo_rue());
			request.setString(4, objet.getVoie());
			request.setString(5, objet.getCode_postal());
			request.setString(6, objet.getVille());
			request.setString(7, objet.getPays());
			request.setInt(8, objet.getId_client());
			
			request.executeUpdate();
			
			if(request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur modification Client : " + error.getMessage());
		}
	}

	@Override
	public void delete(Client objet) {
		try {
			String sql = "DELETE FROM Client WHERE id_client = ?";
			PreparedStatement request = MySQLConnection.getInstance().prepareStatement(sql);
			request.setInt(1, objet.getId_client());
			
			request.executeUpdate();
			
			if (request != null) {
				request.close();
			}
		} catch(SQLException error) {
			System.out.println("Erreur suppression Client : " + error.getMessage());
		}
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
