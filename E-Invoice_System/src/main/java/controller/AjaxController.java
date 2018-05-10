package controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Account;
import model.Invoice;
import model.User;
import service.AccountService;
import service.AdminService;
import service.InvoiceService;
import service.UserService;

@RestController
public class AjaxController {
	@Autowired
	 @Qualifier("userService")
	 UserService userService;
	
	@Autowired
	 @Qualifier("accountService")
	 AccountService accountService;
	
	@Autowired
	 @Qualifier("adminService")
	 AdminService adminService;
	
	@Autowired
	 @Qualifier("invoiceService")
	 InvoiceService invoiceService;


	
	@RequestMapping(value = { "/getInvoiceFromUser" }, method = RequestMethod.GET)
	public Set<Invoice> getInvoiceFromUser(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return this.userService.findbyUserName(userName).getInvoices();
		 }		
	   }
	
	
	@RequestMapping(value = { "/CreateInvoice" }, method = RequestMethod.GET)
	public String createInvoice(Principal principal, Authentication authentication,
			@RequestParam(value="description", required=true) String description, 
	        @RequestParam(value="dateTime", required=true) String dateTime, 
	        @RequestParam(value="amountOfMoney", required=true) String amountOfMoney, 
	        @RequestParam(value="customerCode", required=true) String customerCode,
	        @RequestParam(value="invoiceNo", required=true) String invoiceNo,
	        @RequestParam(value="VAT", required=true) String VAT
	        ) {
		 String userName= principal.getName();
		 
		 if (userName.equals("")) {
		 } else {
			 User currentuser = this.userService.findbyUserName(userName);
			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
			 Date date = new Date();
			try {
				date = formatter.parse(dateTime+ ", 00:00:00.000");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 long cCode = Long.parseLong(customerCode);
			 double money = Double.parseDouble(amountOfMoney);
			 double vat =  Double.parseDouble(VAT);		 
			 this.invoiceService.createInvoice(description, date, money, cCode, invoiceNo, vat, currentuser);	 
		 }		
		 return "{'msg': 'success'}";
	   }
	
	@RequestMapping(value = { "/makeInvoice" }, method = RequestMethod.GET)
	public Invoice makeInvoice(Principal principal, Authentication authentication,
			@RequestParam(value="description", required=true) String description, 
	        @RequestParam(value="dateTime", required=true) String dateTime, 
	        @RequestParam(value="amountOfMoney", required=true) String amountOfMoney, 
	        @RequestParam(value="customerCode", required=true) String customerCode,
	        @RequestParam(value="invoiceNo", required=true) String invoiceNo,
	        @RequestParam(value="VAT", required=true) String VAT
	        ) {
		 String userName= principal.getName();
		 Invoice newinvoice = null;
		 if (userName.equals("")) {
		 } else {
			 User currentuser = this.userService.findbyUserName(userName);
			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
			 Date date = new Date();
			try {
				date = formatter.parse(dateTime+ ", 00:00:00.000");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 long cCode = Long.parseLong(customerCode);
			 double money = Double.parseDouble(amountOfMoney);
			 double vat =  Double.parseDouble(VAT);		 
			 newinvoice = this.invoiceService.MakeInvoice(description, date, money, cCode, invoiceNo, vat, currentuser);	 
		 }		
		 return newinvoice;
	   }
	
	@RequestMapping(value = { "/getInvoiceFromUser/{dateTime}" }, method = RequestMethod.GET)
	public Set<Invoice> getInvoiceFromUser(Principal principal, Authentication authentication,
			@PathVariable("dateTime") String dateTime) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			 Date date = new Date();
				try {
					 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
					
					date = formatter.parse(dateTime+ ", 00:00:00.000");
					 System.out.println(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println(this.userService.findbyUserName(userName).getMoneyReport(2018,1));
			return this.userService.findbyUserName(userName).getInvoices(date);
		 }		
	   }
	
	
	@RequestMapping(value = { "/getreport/{year}/{month}" }, method = RequestMethod.GET)
	public double[] getreport(Principal principal, Authentication authentication,
			@PathVariable("year") int year,
			@PathVariable("month") int month) {
		 String userName= principal.getName();
	
			return this.userService.findbyUserName(userName).getMoneyReport(year,month);

	   }
	
	@RequestMapping(value = { "/getreport/{year}" }, method = RequestMethod.GET)
	public double[] getreport(Principal principal, Authentication authentication,
			@PathVariable("year") int year) {
		 String userName= principal.getName();
	
			return this.userService.findbyUserName(userName).getMoneyReport(year);

	   }
	
	
	@RequestMapping(value = { "/removeinvoice/{id}" }, method = RequestMethod.GET)
	public String removeinvoice(Principal principal, Authentication authentication,
			@PathVariable("id") long id) {
		System.out.println(id);
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return "{'msg': 'fail'}";  
		 } else {
			 User user = this.userService.findbyUserName(userName);
			 this.invoiceService.remove(id, user);
			 return "{'msg': 'success'}";  
		 }		
	   }
	
	
	@RequestMapping(value = { "/getAllUsers" }, method = RequestMethod.GET)
	public List<User> getAllUser(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return this.userService.getAll();
		 }		
	   }
	
	@RequestMapping(value = { "/searchAccount" }, method = RequestMethod.POST)
	public List<Account> searchUser(Principal principal, Authentication authentication, @RequestParam String username, 
			@RequestParam String type) {
		//System.out.println(username + type);
		return this.accountService.searchAccount(username, type);
				
	   }

	
	@RequestMapping(value = { "/updateActive/{id}" }, method = RequestMethod.POST)
	public String updateActive(Principal principal, Authentication authentication,  @PathVariable("id") String idStr, 
			@RequestParam String statusStr) {
		long id = Long.parseLong(idStr, 10);
		Boolean status = Boolean.valueOf(statusStr);
		//System.out.println(username + type);
		accountService.updateActive(id, status);
		return "{ 'msg': 'success'}"; 			
	}
	
	@RequestMapping(value = { "/updateTrigger" }, method = RequestMethod.POST)
	public String updateTrigger(Principal principal, Authentication authentication, @RequestParam String triggerStr) throws Exception{ 
		String trigger = triggerStr;
		adminService.setTrigger(trigger);
		adminService.doSendEmail(trigger);
		return "{ 'msg': 'success'}"; 		
	}
	
	@RequestMapping(value = { "/getAllAccounts" }, method = RequestMethod.GET)
	public List<Account> getAllAccount(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return this.userService.getAllAccount();
		 }		
	   }
}
