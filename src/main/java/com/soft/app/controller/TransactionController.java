package com.soft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.app.model.Transaction;
import com.soft.app.repository.TransactionRepository;

@Controller
public class TransactionController {

	@Autowired private TransactionRepository transactionRepository;
	
	@ModelAttribute("transaction")
	public Transaction getTransaction() {
		return new Transaction();
	}
	
	@RequestMapping(value="**/accountant/addExpense", method=RequestMethod.GET)
		public String loadExpensePage() {
			return "accountant_addExpense";
		
	}
	
	@RequestMapping(value="**/accountant/add-addExpense", method=RequestMethod.POST)
		public String addExpense(@ModelAttribute("transaction")Transaction transaction) {
		transaction.setStatus("expense");	
		transactionRepository.save(transaction);
			return "redirect:accountant/viewTransaction";
		}
	@RequestMapping(value="**/accountant/viewTransaction", method=RequestMethod.GET)
    public String viewTransaction(Model model) {
		model.addAttribute("transactionList", transactionRepository.findAll());
		return "accountant_viewTransaction";
		
	}
	
	@RequestMapping(value="**/manager/viewTransaction", method=RequestMethod.GET)
    public String manager_viewTransaction(Model model) {
		model.addAttribute("transactionList", transactionRepository.findAll());
		return "manager_viewTransaction";
		
	}
	

}
