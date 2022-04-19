package ua.hasperskyy.models;

public class Bank {

	private int id;
	private String name;
	private int rate;
	private int max_Loan;
	private int min_Payment;
	private int loan_Term;
	
	public Bank() {}

	public Bank(String name, int rate, int max_Loan, int min_Payment, int loan_Term) {
		this.name = name;
		this.rate = rate;
		this.max_Loan = max_Loan;
		this.min_Payment = min_Payment;
		this.loan_Term = loan_Term;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getMax_Loan() {
		return max_Loan;
	}

	public void setMax_Loan(int max_Loan) {
		this.max_Loan = max_Loan;
	}

	public int getMin_Payment() {
		return min_Payment;
	}

	public void setMin_Payment(int min_Payment) {
		this.min_Payment = min_Payment;
	}

	public int getLoan_Term() {
		return loan_Term;
	}

	public void setLoan_Term(int loan_Term) {
		this.loan_Term = loan_Term;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loan_Term;
		result = prime * result + max_Loan;
		result = prime * result + min_Payment;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (loan_Term != other.loan_Term)
			return false;
		if (max_Loan != other.max_Loan)
			return false;
		if (min_Payment != other.min_Payment)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rate != other.rate)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", rate=" + rate + ", max_Loan=" + max_Loan + ", min_Payment="
				+ min_Payment + ", loan_Term=" + loan_Term + "]";
	}

}