package controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	 @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	   public String adminPage(Principal principal, Authentication authentication) {
	       return "adminPage";  
	   }
}
