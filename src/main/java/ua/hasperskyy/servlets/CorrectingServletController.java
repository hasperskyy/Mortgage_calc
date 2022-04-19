package ua.hasperskyy.servlets;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.hasperskyy.DAO.BankDAO;
import ua.hasperskyy.DAO.FactoryDAO;
import ua.hasperskyy.controllers.Utilites;
import ua.hasperskyy.models.Bank;

@Controller
@RequestMapping ("/correcting")
public class CorrectingServletController {

	
	@RequestMapping (method = RequestMethod.GET, params = {"name"})
	public String showForm (@RequestParam("name") String name, 
		HttpSession session, ModelMap model) {
		
		FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
		BankDAO bankDAO = factory.getBankDAO();
		Bank bank = bankDAO.getBankByName(name);
		model.addAttribute("bank", bank);
		
		return "CorrectingView";
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public String correctForm(@RequestParam("Name") String name,
			@RequestParam(required = false, name = "Rate") String rate,
			@RequestParam(required = false, name = "Max_Loan") String max_loan,
			@RequestParam(required = false, name = "Min_Payment") String min_payment,
			@RequestParam(required = false, name = "Loan_Term") String loan_term,
			HttpSession session, ModelMap model) {
		
		Utilites utilites = new Utilites();
		FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
		BankDAO bankDAO = factory.getBankDAO();
		boolean showForm = true;
		boolean isError = false;

		model.addAttribute("name", name);
		model.addAttribute("rate", rate);
		model.addAttribute("max_loan", max_loan);
		model.addAttribute("min_payment", min_payment);
		model.addAttribute("loan_term", loan_term);
		
		if (rate == null && max_loan == null && min_payment == null && loan_term == null) {
		}

		else {
		
			if (rate != null && rate.length() == 0) {
				isError = true;
				utilites.setErrorText("Rate is empty <br>");
			} else {
				if (!utilites.isDataCorrect(rate)) {
					isError = true;
					utilites.setErrorText("Rate is not Correct <br>");
				}
			}
			
			if (max_loan != null && max_loan.length() == 0) {
				isError = true;
				utilites.setErrorText("Maximum loan is empty <br>");
			} else {
				if (!utilites.isDataCorrect(max_loan)) {
					isError = true;
					utilites.setErrorText("Maximum loan is not Correct <br>");
				}
			}
			
			if (min_payment != null && min_payment.length() == 0) {
				isError = true;
				utilites.setErrorText("Minimum payment is empty <br>");
			} else {
				if (!utilites.isDataCorrect(min_payment)) {
					isError = true;
					utilites.setErrorText("Minimum payment is not Correct <br>");
				}
			}
			
			if (loan_term != null && loan_term.length() == 0) {
				isError = true;
				utilites.setErrorText("Loan term is empty <br>");
			} else {
				if (!utilites.isDataCorrect(loan_term)) {
					isError = true;
					utilites.setErrorText("Loan term is not Correct <br>");
				}
			}
			
			if (!isError) {
				showForm = false;
				bankDAO.updateBank(name, Integer.parseInt(rate), Integer.parseInt(max_loan),
						Integer.parseInt(min_payment), Integer.parseInt(loan_term));
				return "DoneView";
			}
			
			model.addAttribute("utilites", utilites);
			System.out.println(utilites.getErrorText());
			
			if (showForm) {
				return "CorrectingView";
			}
		}
	return "CorrectingView";
	}
}
