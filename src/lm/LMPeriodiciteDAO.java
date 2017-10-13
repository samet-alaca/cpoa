package lm;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import pojo.Periodicite;

public class LMPeriodiciteDAO implements DAO<Periodicite> {

	private static LMPeriodiciteDAO instance;
	
	private List<Periodicite> data = new ArrayList<Periodicite>();
	
	private LMPeriodiciteDAO() {
		this.create(new Periodicite(1, "Quotidien"));
		this.create(new Periodicite(1, "Hebdomadaire"));
		
	}

	public static LMPeriodiciteDAO getInstance() {
		if(instance == null) {
			instance = new LMPeriodiciteDAO();
		}
		return instance;
	}

	@Override
	public Periodicite getById(int id) {
		for(Periodicite objet : this.data) {
			if(objet.getId() == id) {
				return objet;
			}
		}
		return null;
	}

	@Override
	public void create(Periodicite objet) {
		this.data.add(objet);
	}

	@Override
	public void update(Periodicite objet) {
		this.data.set(
			this.data.indexOf(
				this.getById(objet.getId())
			),
			objet
		);
	}

	@Override
	public void delete(Periodicite objet) {
		this.data.remove(objet);
	}

	@Override
	public List<Periodicite> getAll() {
		return this.data;
	}

}
