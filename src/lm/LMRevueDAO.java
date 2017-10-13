package lm;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import pojo.Revue;

public class LMRevueDAO implements DAO<Revue> {

	private static LMRevueDAO instance;
	
	private List<Revue> data = new ArrayList<Revue>();
	
	private LMRevueDAO() {
		
	}

	public static LMRevueDAO getInstance() {
		if(instance == null) {
			instance = new LMRevueDAO();
		}
		return instance;
	}

	@Override
	public Revue getById(int id) {
		for(Revue objet : this.data) {
			if(objet.getId_revue() == id) {
				return objet;
			}
		}
		return null;
	}

	@Override
	public void create(Revue objet) {
		this.data.add(objet);
	}

	@Override
	public void update(Revue objet) {
		this.data.set(
				this.data.indexOf(
					this.getById(objet.getId_revue())
				),
				objet
			);
	}

	@Override
	public void delete(Revue objet) {
		this.data.remove(objet);
	}

	@Override
	public List<Revue> getAll() {
		return this.data;
	}

}
