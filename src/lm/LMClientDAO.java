package lm;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import pojo.Client;

public class LMClientDAO implements DAO<Client> {
	
	private static LMClientDAO instance;
	
	private List<Client> data = new ArrayList<Client>();
	
	private LMClientDAO() {
		
	}

	public static LMClientDAO getInstance() {
		if(instance == null) {
			instance = new LMClientDAO();
		}
		return instance;
	}
	
	@Override
	public Client getById(int id) {
		for(Client objet : this.data) {
			if(objet.getId_client() == id) {
				return objet;
			}
		}
		return null;
	}

	@Override
	public void create(Client objet) {
		this.data.add(objet);
	}

	@Override
	public void update(Client objet) {
		this.data.set(
			this.data.indexOf(
				this.getById(objet.getId_client())
			),
			objet
		);
	}

	@Override
	public void delete(Client objet) {
		this.data.remove(objet);
	}

	@Override
	public List<Client> getAll() {
		return this.data;
	}

}
