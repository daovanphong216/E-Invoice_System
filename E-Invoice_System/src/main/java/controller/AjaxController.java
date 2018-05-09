package controller;

import java.security.Principal;
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

	
	@RequestMapping(value = { "/getInvoiceFromUser" }, method = RequestMethod.GET)
	public Set<Invoice> getInvoiceFromUser(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return this.userService.findbyUserName(userName).getInvoices();
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
