package factory;

import dao.*;
import pojo.*;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance target) {
		
		switch(target) {
			case MYSQL:
				return new MySQLDAOFactory();
			case LM:
				return new LMDAOFactory();
			default:
				return null;
		}
	}
	
	public abstract AbonnementDAO getAbonnementDAO();
	public abstract DAO<Client> getClientDAO();
	public abstract DAO<Periodicite> getPeriodiciteDAO();
	public abstract DAO<Revue> getRevueDAO();
}
