package controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	// @Autowired
	// @Qualifier("accountService")
	// AccountService accountService;
	//

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String dashboardPage(Principal principal, Authentication authentication) {
		String userName = principal.getName();

		if (userName.equals("")) {
			return "redirect:/login";
		} else {
			String role = authentication.getAuthorities().toArray()[0].toString();
			System.out.println(this.userService.findbyUserName(userName).getId());

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
	public String registerNewUser(Model model,@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password, 
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "telNo", required = true) String telNo) {
		
		boolean checkDupplicate = this.userService.checkDuplicatedUser(username);
		if (checkDupplicate) {
			model.addAttribute("message","Username dupplicated!" );
			model.addAttribute("error",true );
			return "registerPage";
		} else {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.userService.createMember(username, passwordEncoder.encode(password), name, telNo, email, address);

			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logoutsuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		return "redirect:/login";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}
}
