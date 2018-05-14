package controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Invoice;
import service.AccountService;
import service.EmailService;
import service.InvoiceService;
import service.InvoiceTypeService;
import service.UserService;

@RestController
public class SearchController {
	@Autowired
	 @Qualifier("userService")
	 UserService userService;
	
	@Autowired
	 @Qualifier("accountService")
	 AccountService accountService;
	

	
	@Autowired
	@Qualifier("emailService")
	EmailService emailService;
	
	@Autowired
	 @Qualifier("invoiceService")
	 InvoiceService invoiceService;
	
	@Autowired
	 @Qualifier("invoiceTypeService")
	 InvoiceTypeService invoiceTypeService;
	
	@RequestMapping(value = { "/SearchInvoice}" }, method = RequestMethod.GET)
	public Set<Invoice> searchInvoice(Principal principal, Authentication authentication,
		
			@RequestParam(value="dateMin", required=false) String dateMin,
			@RequestParam(value="dateMax", required=false) String dateMax,
			@RequestParam(value="moneyMin", required=false) double moneyMin,
			@RequestParam(value="moneyMax", required=false) double moneyMax,
			@RequestParam(value="cCode", required=false) long cCode,
			@RequestParam(value="invoiceNo", required=false) String invoiceNo,
			@RequestParam(value="type", required=false) String type
			
			) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			 Date datemin = new Date();
			 Date datemax = new Date();
				try {
					 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");		
					 datemin = formatter.parse(dateMin+ ", 00:00:00.000");
					 datemax = formatter.parse(dateMax+ ", 00:00:00.000");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			return this.userService.findbyUserName(userName).getInvoices(datemin,datemax,moneyMin,moneyMax, cCode, invoiceNo, type);
		 }		
	   }
	
	
}
