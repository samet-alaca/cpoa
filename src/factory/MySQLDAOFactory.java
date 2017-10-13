package factory;

import dao.*;
import mysql.*;
import pojo.*;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public AbonnementDAO getAbonnementDAO() {
		return MySQLAbonnementDAO.getInstance();
	}

	@Override
	public DAO<Client> getClientDAO() {
		return MySQLClientDAO.getInstance();
	}

	@Override
	public DAO<Periodicite> getPeriodiciteDAO() {
		return MySQLPeriodiciteDAO.getInstance();
	}

	@Override
	public DAO<Revue> getRevueDAO() {
		return MySQLRevueDAO.getInstance();
	}
}
