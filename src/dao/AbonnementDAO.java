package dao;

import pojo.Abonnement;

public interface AbonnementDAO extends DAO<Abonnement> {
	public abstract Abonnement getById(int id_client, int id_revue);
}
