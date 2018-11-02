package com.soft.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Transaction;
import com.soft.app.repository.MonthRepository;
import com.soft.app.repository.TransactionRepository;

@Controller
public class TransactionController {

	@Autowired private TransactionRepository transactionRepository;
	@Autowired private MonthRepository monthRepository;
	
	@ModelAttribute("transaction")
	public Transaction getTransaction() {
		return new Transaction();
	}
	
	@RequestMapping(value="**/accountant/addExpense", method=RequestMethod.GET)
		public String loadExpensePage() {
			return "accountant_addExpense";
		
	}
	
	@RequestMapping(value="**/accountant/add-addExpense", method=RequestMethod.POST)
		public String addExpense(@ModelAttribute("transaction")Transaction transaction) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
       transaction.setDate(date1);
       
       double balance=transactionRepository.getBalance();
       double newbalance=balance-transaction.getAmount();
       transaction.setBalance(newbalance);
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
	
	@RequestMapping(value="**/accountant/viewPL", method=RequestMethod.GET)
	public String SelectMonth(Model model) {
		model.addAttribute("monthList",monthRepository.findAll() );
		return "accountant_viewMonth";
	}
	
	@RequestMapping(value="**/accountant/viewPLStatement", method=RequestMethod.GET)
	public String viewPl(@RequestParam("id")int id, Model model1,Model model2,Model model3,Model model4,Model model5, Model model6, Model model7, Model model8)throws Exception{
		System.out.println(id);
		double studentFee=transactionRepository.getStudentFee(id);
		System.out.println(studentFee);
		double teacherSalary=transactionRepository.getTeacherSalary(id);
		double staffSalary=transactionRepository.getStaffSalary(id);
		double miscIncome=transactionRepository.getMiscIncome(id);
		double miscExpense=transactionRepository.getMiscExpense(id);
		double totalIncome=studentFee+miscIncome;
		double totalExpense=staffSalary+miscExpense+teacherSalary;
		double netIncome=totalIncome-totalExpense;
		model1.addAttribute("studentFee", studentFee);
		model2.addAttribute("teacherSalary", teacherSalary);
		model3.addAttribute("staffSalary", staffSalary);
		model4.addAttribute("miscIncome", miscIncome);
		model5.addAttribute("miscExpense", miscExpense);
		model6.addAttribute("totalExpense", totalExpense);
		model7.addAttribute("totalIncome", totalIncome);
		model8.addAttribute("netIncome", netIncome);
		
		return "accountantPLStatement";
		
		
	}
	

}
