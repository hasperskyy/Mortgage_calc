package ua.hasperskyy.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.hasperskyy.DAO.BankDAO;
import ua.hasperskyy.DAO.FactoryDAO;

public class MySQLFactoryDAO extends FactoryDAO {

	@Override
	public BankDAO getBankDAO() {
		return new MySQLBankDAO();
	}

	@Override
	public Connection openConnection() {
	
		connection = null;
		
		try {
			connection =
		       DriverManager.getConnection("jdbc:mysql://localhost/calculator?" +
		                                   "user=root&password=");

		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return connection;
	}

	@Override
	public void closeConnection() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}