package controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Account;
import model.User;
import service.AccountService;
import service.AdminService;

@Controller
public class AdminController {
	@Autowired
	 @Qualifier("adminService")
	 AdminService adminService;
	
	@Autowired
	@Qualifier("accountService")
	AccountService accountService;
	
	 @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	   public String adminPage(Model model, Principal principal, Authentication authentication) {
		   model.addAttribute("trigger", adminService.getTrigger());
	       return "adminPage";  
	   }
	 
	 @RequestMapping(value = "/userinfo/{id}", method = RequestMethod.GET)
		public String userInfo(Model model, @PathVariable("id") String idStr, Principal principal,
				Authentication authentication) {
			
			long id = Long.parseLong(idStr, 10);
			User user = accountService.findbyId(id).getUser();
			if (user == null) {
				return "redirect:/nofounded";
			} else {
					String username = accountService.findbyId(id).getUserName();
					model.addAttribute("user",user);
					model.addAttribute("username",username);
					model.addAttribute("isAdmin",true);
					return "userInfoPage";
				
			}
		}
}
