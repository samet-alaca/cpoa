package lm;

import java.util.ArrayList;
import java.util.List;

import dao.AbonnementDAO;
import pojo.Abonnement;

public class LMAbonnementDAO implements AbonnementDAO {
	
	private static LMAbonnementDAO instance;
	
	private List<Abonnement> data = new ArrayList<Abonnement>();
	
	private LMAbonnementDAO() {
		
	}

	public static LMAbonnementDAO getInstance() {
		if(instance == null) {
			instance = new LMAbonnementDAO();
		}
		return instance;
	}

	@Override
	public Abonnement getById(int id) {
		return null;
	}

	@Override
	public Abonnement getById(int id_client, int id_revue) {
		for(Abonnement objet : this.data) {
			if(objet.getId_client() == id_client && objet.getId_revue() == id_revue) {
				return objet;
			}
		}
		return null;
	}
	
	@Override
	public void create(Abonnement objet) {
		this.data.add(objet);
	}

	@Override
	public void update(Abonnement objet) {
		this.data.set(
			this.data.indexOf(
				this.getById(
					objet.getId_client(),
					objet.getId_revue()
				)
			),
			objet
		);
	}

	@Override
	public void delete(Abonnement objet) {
		this.data.remove(objet);
	}

	@Override
	public List<Abonnement> getAll() {
		return this.data;
	}
}
