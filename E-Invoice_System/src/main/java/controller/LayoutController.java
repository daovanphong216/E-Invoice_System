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
	       return "testLayout";  
	   }

}
