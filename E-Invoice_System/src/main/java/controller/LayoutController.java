package controller;
import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LayoutController {
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	   public String adminPag(){
	       return "List_invoice";  
	   }
	
	@RequestMapping(value = { "/info" }, method = RequestMethod.GET)
	   public String adminPage(Principal principal, Authentication authentication) {
	       return "userInfo";  
	   }
	@RequestMapping(value = { "/invoices" }, method = RequestMethod.GET)
	   public String invoices(Principal principal, Authentication authentication) {
	       return "invoices";  
	   }

}
