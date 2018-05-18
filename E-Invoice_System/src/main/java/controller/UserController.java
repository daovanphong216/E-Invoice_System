package controller;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Account;
import model.InvoiceType;
import model.User;
import service.AccountService;
import service.InvoiceService;
import service.InvoiceTypeService;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	 @Qualifier("invoiceService")
	 InvoiceService invoiceService;
	
	@Autowired
	 @Qualifier("invoiceTypeService")
	 InvoiceTypeService invoiceTypeService;
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal,
			Authentication authentication) {
		User user = userService.findbyUserName(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("username", principal.getName());
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
	
	@RequestMapping(value = { "/yearlychart" }, method = RequestMethod.GET)
	   public String yearlychart(Model model, Principal principal, Authentication authentication) {
			User user = userService.findbyUserName(principal.getName());
			model.addAttribute("user",user);
	        return "YearlyChart";  
	   }
	@RequestMapping(value = { "/monthlychart" }, method = RequestMethod.GET)
	   public String monthlychart(Model model, Principal principal, Authentication authentication) {
			User user = userService.findbyUserName(principal.getName());
			model.addAttribute("user",user);
	        return "MonthlyChart";  
	   }

	@RequestMapping(value = { "/charts" }, method = RequestMethod.GET)
	   public String charts(Model model, Principal principal, Authentication authentication) {
			User user = userService.findbyUserName(principal.getName());
			model.addAttribute("user",user);
	        return "chars";  
	   }
	
	@RequestMapping(value = { "/Search" }, method = RequestMethod.GET)
	   public String Search(Model model, Principal principal, Authentication authentication,
			   @RequestParam(value="dateMin", required=true) String dateMin,
				@RequestParam(value="dateMax", required=true) String dateMax,
				@RequestParam(value="moneyMin", required=true) double moneyMin,
				@RequestParam(value="moneyMax", required=true) double moneyMax,
				@RequestParam(value="cCode", required=true) long cCode,
				@RequestParam(value="invoiceNo", required=true) String invoiceNo,
				@RequestParam(value="type", required=true) long typeId,
				@RequestParam(value="firstResult", required=true) int firstResult,
				@RequestParam(value="maxResults", required=true) int maxResults) {
		
		
		
			User currentUser = userService.findbyUserName(principal.getName());
			model.addAttribute("user",currentUser);
			int totalResults=0;
			int totalPages=0;
			int currentPage=0;
			Date datemin = new Date();
			Date datemax = new Date();
				try {
					 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");		
					 datemin = formatter.parse(dateMin+ ", 00:00:00.000");
					 datemax = formatter.parse(dateMax+ ", 00:00:00.000");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				
				if(typeId !=0 ) {
					InvoiceType type = this.invoiceTypeService.findbyId(typeId);
					totalResults = this.invoiceService.count(datemin, datemax, moneyMin, moneyMax, cCode, invoiceNo, type, currentUser);
				}
				
				else {
					totalResults = this.invoiceService.count(datemin, datemax, moneyMin, moneyMax, cCode, invoiceNo, currentUser);
				}
				
				if (totalResults > 0) {
					 totalPages =  (int) Math.ceil(((double)totalResults) / 10);
				 } else
				 {
					 totalPages=0;
					 //page=0;
				 }
				currentPage=(firstResult/10)+1;
				int to = firstResult+10;
				if (to>totalResults) {
					to = totalResults;
				}
				model.addAttribute("totalResults",totalResults);
				model.addAttribute("from",firstResult+1);
				model.addAttribute("to",to);
				model.addAttribute("totalPages",totalPages);
				model.addAttribute("currentPage",currentPage);
	        return "searchPage";  
	   }

}
