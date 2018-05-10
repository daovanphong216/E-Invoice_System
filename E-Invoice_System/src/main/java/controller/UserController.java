package controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal,
			Authentication authentication) {
		User user = userService.findbyUserName(principal.getName());
		model.addAttribute("user", user);
		return "userInfoPage";
	}
	
	@RequestMapping(value = { "/invoices" }, method = RequestMethod.GET)
	   public String invoices(Model model, Principal principal, Authentication authentication) {
			User user = userService.findbyUserName(principal.getName());
			model.addAttribute("user",user);
	        return "invoices";  
	   }
	@RequestMapping(value = { "/dailyinvoices" }, method = RequestMethod.GET)
	   public String dailyIncoices(Model model, Principal principal, Authentication authentication) {
			User user = userService.findbyUserName(principal.getName());
			model.addAttribute("user",user);
	        return "DailyInvoices";  
	   }
	@RequestMapping(value = { "/invoiceItem" }, method = RequestMethod.GET)
	   public String invoiceItem(Model model, Principal principal, Authentication authentication) {
			User user = userService.findbyUserName(principal.getName());
			model.addAttribute("user",user);
	        return "invoiceItem";  
	   }

}
