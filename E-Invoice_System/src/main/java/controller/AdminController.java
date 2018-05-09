package controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AdminService;

@Controller
public class AdminController {
	@Autowired
	 @Qualifier("adminService")
	 AdminService adminService;
	
	
	 @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	   public String adminPage(Model model, Principal principal, Authentication authentication) {
		   model.addAttribute("trigger", adminService.getTrigger());
	       return "adminPage";  
	   }
}
