package ua.hasperskyy.DAO;

import java.sql.Connection;
import ua.hasperskyy.MySQL.MySQLFactoryDAO;

public abstract class FactoryDAO {

	public abstract BankDAO getBankDAO();
	protected Connection connection;
	public abstract Connection openConnection();
	public abstract void closeConnection();
	
	public FactoryDAO() {
	}

	
	public static FactoryDAO getFactoryDAO(int type) {
		switch (type) {
		case 1:
			return new MySQLFactoryDAO();
		default:
			return null;
		}
	}
}
