package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Account;
import model.User;
import service.AccountService;
import service.UserService;

@Controller
public class AccountController {

	 @Autowired
	 @Qualifier("userService")
	 UserService userService;
	 
	 @Autowired
	 @Qualifier("accountService")
	 AccountService accountService;
	

	
	 @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	   public String dashboardPage() {
	       return "loginPage";  
	   }
	 
	 @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	   public String loginPage() {
	       return "loginPage";
	   }
	 
	 @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	   public String registerPage() {
	       return "registerPage";
	   }
	 
	 @RequestMapping(value = "/register", method = RequestMethod.POST)
	 public String registerNewUser(  @RequestParam(value="username", required=true) String username, 
		        @RequestParam(value="password", required=true) String password) {
		 	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			Account account = new Account();
			User user = new User();
			
			account.setActive(true);
			account.setRole("MEMBER");
			account.setUserName(username);
			account.setHashPassword(passwordEncoder.encode(password));
			accountService.create(account);
			
			user.setEmail("123@gmail.com");
			user.setName("Phong <3");
			user.setAccount(account);
			
			userService.create(user);

			//String hashedPassword = passwordEncoder.encode(password);
	        //System.out.println(hashedPassword);
	       return "redirect:/register";  
	    }
}
