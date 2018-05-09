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
	
	@RequestMapping(value = { "/invoices" }, method = RequestMethod.GET)
	   public String invoices(Principal principal, Authentication authentication) {
	       return "invoices";  
	   }
	@RequestMapping(value = { "/dailyinvoices" }, method = RequestMethod.GET)
	   public String dailyIncoices(Principal principal, Authentication authentication) {
	       return "DailyInvoices";  
	   }
	@RequestMapping(value = { "/invoiceItem" }, method = RequestMethod.GET)
	   public String invoiceItem(Principal principal, Authentication authentication) {
	       return "invoiceItem";  
	   }

}
