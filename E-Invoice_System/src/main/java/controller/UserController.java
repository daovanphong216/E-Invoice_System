package controller;

import java.security.Principal;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	 @RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	   public String dashboardPage(Principal principal, Authentication authentication) {		 
	      return "userPage";  
	   }
}
