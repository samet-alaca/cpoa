package factory;

import dao.*;
import lm.*;
import pojo.*;

public class LMDAOFactory extends DAOFactory {

	@Override
	public AbonnementDAO getAbonnementDAO() {
		return LMAbonnementDAO.getInstance();
	}

	@Override
	public DAO<Client> getClientDAO() {
		return LMClientDAO.getInstance();
	}

	@Override
	public DAO<Periodicite> getPeriodiciteDAO() {
		return LMPeriodiciteDAO.getInstance();
	}

	@Override
	public DAO<Revue> getRevueDAO() {
		return LMRevueDAO.getInstance();
	}

}
