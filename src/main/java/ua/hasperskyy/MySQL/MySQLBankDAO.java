package ua.hasperskyy.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.TreeSet;

import ua.hasperskyy.DAO.BankDAO;
import ua.hasperskyy.controllers.BankCompareByName;
import ua.hasperskyy.models.Bank;

public class MySQLBankDAO implements BankDAO {

	private static final String GET_BANK_BY_NAME_QUERY = "Select * FROM bank WHERE name = ?";
	
	private static final String GET_ALL_BANK_QUERY = "Select * FROM bank";
	
	private static final String INSERT_QUERY = "INSERT INTO bank (name,rate,loan,payment,term)"
			+ "VALUES (?,?,?,?,?)";
	
	private static final String UPDATE_QUERY = "UPDATE bank SET name = ?, rate = ?, loan = ?,"
			+ "payment = ?, term = ? WHERE name = ?";
	
	private static final String DELETE_QUERY = "DELETE FROM bank WHERE name = ?";
	
	MySQLFactoryDAO dao = new MySQLFactoryDAO();
	
	@Override
	public TreeSet<Bank> getBankList() {
	
		Comparator<Bank> bankCompare = new BankCompareByName();
		TreeSet<Bank> bankSet = new TreeSet<Bank>(bankCompare);
		
		Connection connection = dao.openConnection();
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = connection.createStatement();
		    rs = stmt.executeQuery(GET_ALL_BANK_QUERY);

		    while (rs.next()) {
		        Bank bank = new Bank();
		        bank.setId(rs.getInt("id"));
		        System.out.println(bank.getId());
		        bank.setName(rs.getString("name"));
		        System.out.println(bank.getName());
		        bank.setRate(rs.getInt("rate"));
		        System.out.println(bank.getRate());
		        bank.setMax_Loan(rs.getInt("loan"));
		        System.out.println(bank.getMax_Loan());
		        bank.setMin_Payment(rs.getInt("payment"));
		        System.out.println(bank.getMin_Payment());
		        bank.setLoan_Term(rs.getInt("term"));
		        System.out.println(bank.getLoan_Term());
		        bankSet.add(bank);
		    }

		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
		        stmt = null;
		    }
		    dao.closeConnection();
		}
		return bankSet;
	}

	@Override
	public Bank getBankByName(String name) {
	
		Connection connection = dao.openConnection();
		
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			preStmt = connection.prepareStatement(GET_BANK_BY_NAME_QUERY);
			preStmt.setString(1, name);
			rs = preStmt.executeQuery();
			Bank bank;

			if (rs.next()) {
				bank = new Bank();
				bank.setId(rs.getInt("id"));
		        System.out.println(bank.getId());
		        bank.setName(rs.getString("name"));
		        System.out.println(bank.getName());
		        bank.setRate(rs.getInt("rate"));
		        System.out.println(bank.getRate());
		        bank.setMax_Loan(rs.getInt("loan"));
		        System.out.println(bank.getMax_Loan());
		        bank.setMin_Payment(rs.getInt("payment"));
		        System.out.println(bank.getMin_Payment());
		        bank.setLoan_Term(rs.getInt("term"));
		        System.out.println(bank.getLoan_Term());
		        return bank;
			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}
				rs = null;
			}

			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (SQLException sqlEx) {
				}
				preStmt = null;
			}
			dao.closeConnection();
		}
		return null;
	}

	@Override
	public boolean isUnique(String name) {

		Connection connection = dao.openConnection();
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		boolean isUnique = true;
		
		try {
			ps = connection.prepareStatement(GET_BANK_BY_NAME_QUERY);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				isUnique = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		dao.closeConnection();
	return isUnique;
	}

	@Override
	public void createBank(String name, int rate, int max_Loan, int min_Payment, int loan_Term) {
		
		Connection connection = dao.openConnection();
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(INSERT_QUERY);
			ps.setString(1, name);
			ps.setInt(2, rate);
			ps.setInt(3, max_Loan);
			ps.setInt(4, min_Payment);
			ps.setInt(5, loan_Term);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		finally {
			
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		dao.closeConnection();
	}

	@Override
	public void updateBank(String name, int rate, int max_Loan, int min_Payment, int loan_Term) {
		
		Connection connection = dao.openConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(UPDATE_QUERY);
			ps.setString(1, name);
			ps.setInt(2, rate);
			ps.setInt(3, max_Loan);
			ps.setInt(4, min_Payment);
			ps.setInt(5, loan_Term);
			ps.setString(6, name);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		dao.closeConnection();
	}

	@Override
	public void deleteBankByName(String name) {
		
		Connection connection = dao.openConnection();
		System.out.println("Name from SQL " + name);
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(DELETE_QUERY);
			ps.setString(1, name);
			ps.executeUpdate();
			
			System.out.println("Updated");
			

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {

		if (ps != null) {
				try {
					ps.close();
				} catch (SQLException sqlEx) {
				}

				ps = null;
			}
			dao.closeConnection();
		}
	}
}