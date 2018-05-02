package controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.UserService;

@Controller
public class AccountController {

	 @Autowired
	 @Qualifier("userService")
	 UserService userService;
	 
//	 @Autowired
//	 @Qualifier("accountService")
//	 AccountService accountService;
//	

	
	 @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	 public String dashboardPage(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 
		 if (userName.equals("")) {
			 return "redirect:/login";  
		 } else {
			 String role= authentication.getAuthorities().toArray()[0].toString();
			 switch (role) {
			 	case "ROLE_MEMBER": 
			 		return "forward:/user";
				case "ROLE_ADMIN": 
				 	return "redirect:/admin";
				default: 
				 	return "redirect:/login";
			 }
		 }
		
	   }
	 
	 @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	   public String loginPage() {
	       return "loginPage";
	   }
	 
	 @RequestMapping(value = { "/register" }, method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	   public String registerPage() {
	     return "registerPage";
	   }
	 
	 @RequestMapping(value = "/register", method = RequestMethod.POST)
	 public String registerNewUser(  @RequestParam(value="username", required=true) String username, 
		        @RequestParam(value="password", required=true) String password) {
		 	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 	
		 	this.userService.createMember(username, passwordEncoder.encode(password), "tu", "032", "hihi@df", "huhu");

	       return "redirect:/login";  
	    }
		 @RequestMapping(value = "/logoutsuccessful", method = RequestMethod.GET)
		   public String logoutSuccessfulPage(Model model) {
		      return "redirect:/login";   
		  }
		 @RequestMapping(value = "/403", method = RequestMethod.GET)
		   public String accessDenied(Model model, Principal principal) {
		        
		       if (principal != null) {
		           model.addAttribute("message", "Hi " + principal.getName()
		                   + "<br> You do not have permission to access this page!");
		       } else {
		           model.addAttribute("msg",
		                   "You do not have permission to access this page!");
		       }
		       return "403Page";
		   }
}
