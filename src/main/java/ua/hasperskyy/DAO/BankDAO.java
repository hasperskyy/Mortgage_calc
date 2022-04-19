package ua.hasperskyy.DAO;

import java.util.TreeSet;
import ua.hasperskyy.models.Bank;

public interface BankDAO {

	public TreeSet<Bank> getBankList();
	public Bank getBankByName(String name);
	public boolean isUnique (String name);
	public void createBank (String name, int rate, int max_Loan, int min_Payment, int loan_Term);
	public void updateBank (String name, int rate, int max_Loan, int min_Payment, int loan_Term);
	public void deleteBankByName (String name); 
}
	

