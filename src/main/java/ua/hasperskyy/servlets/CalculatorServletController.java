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
@RequestMapping("/calculator")
public class CalculatorServletController {

	@RequestMapping(method = RequestMethod.GET)
	public String showCalculator(HttpSession session, ModelMap model) {
		return "CalculatorView";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String useCalculator(@RequestParam(required = false, name = "Loan") String loan,
			@RequestParam(required = false, name = "Payment") String payment,
			@RequestParam(required = false, name = "Name") String name, HttpSession session, ModelMap model) {

		FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
		BankDAO bankDAO = factory.getBankDAO();
		Bank bank;
		Utilites utilites = new Utilites();
		double mounthlyPay;
		double loanD = 0;
		double paymentD = 0;

		if (loan != null && loan.length() != 0 && utilites.isDataCorrect(loan)) {
			loanD = Double.parseDouble(loan);
			System.out.println("LoanD" + loanD);
		}

		if (payment != null && payment.length() != 0 && utilites.isDataCorrect(payment)) {
			paymentD = Double.parseDouble(payment);
			System.out.println("PaymentD" + paymentD);
		}

		bank = bankDAO.getBankByName(name);

		if (loanD !=0 && paymentD !=0 && paymentD >= bank.getMin_Payment()) {
			mounthlyPay = ((loanD - paymentD) * ((double) bank.getRate() / 12)
					* Math.pow((1 + (double) bank.getRate() / 12), (double) bank.getLoan_Term()))
					/ (Math.pow((1 + (double) bank.getRate() / 12), (double) bank.getLoan_Term()) - 1);

			String result = String.format("%.2f",mounthlyPay);
			
			model.addAttribute("mounthlyPay", result);
			System.out.println(result);
		}
		else {
			utilites.setErrorText("Your payment is not enouhgt for this BANK");
			model.addAttribute("utilites", utilites);
		}
		return "CalculatorView";

	}
}