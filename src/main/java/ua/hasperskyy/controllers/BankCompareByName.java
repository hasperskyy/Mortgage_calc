package ua.hasperskyy.controllers;

import java.util.Comparator;

import ua.hasperskyy.models.Bank;

public class BankCompareByName implements Comparator<Bank>{

	@Override
	public int compare(Bank bank_1, Bank bank_2) {
		return bank_1.getName().compareTo(bank_2.getName());
	}

}
