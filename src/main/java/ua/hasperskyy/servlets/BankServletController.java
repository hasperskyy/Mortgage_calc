package ua.hasperskyy.servlets;

import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.hasperskyy.DAO.BankDAO;
import ua.hasperskyy.DAO.FactoryDAO;
import ua.hasperskyy.models.Bank;

@Controller
@RequestMapping("/bank")
public class BankServletController {

	@RequestMapping(method = RequestMethod.GET)
	public String showBank(@RequestParam(required = false, name = "deleteBank") String deleteBank, ModelMap model) {

		if (deleteBank == null) {

			FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
			BankDAO bankDAO = factory.getBankDAO();
			TreeSet<Bank> bankSet;

			bankSet = bankDAO.getBankList();
			model.addAttribute("bankSet", bankSet);

			return "BankView";
		}

		else {

			FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
			BankDAO bankDAO = factory.getBankDAO();
			TreeSet<Bank> bankSet = bankDAO.getBankList();
			Bank bank = bankDAO.getBankByName(deleteBank);

			System.out.println("DeleteBank - " + deleteBank);

			if (deleteBank != null) {
				bankDAO.deleteBankByName(deleteBank);
				bankSet.remove(bank);
				model.addAttribute("bankSet", bankSet);
			}
			return "DoneView";

		}
	}
}
