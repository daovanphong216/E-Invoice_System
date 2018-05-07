package controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.InvoiceService;
import service.UserService;




@Controller
public class InvoiceController {
	@Autowired
	 @Qualifier("userService")
	 UserService userService;
	@Autowired
	 @Qualifier("invoiceService")
	 InvoiceService invoiceService;
	
	@RequestMapping(value = { "/CreateInvoice" }, method = RequestMethod.GET)
	public void createInvoice(Principal principal, Authentication authentication,
			@RequestParam(value="description", required=true) String description, 
	        @RequestParam(value="dateTime", required=true) String dateTime, 
	        @RequestParam(value="amountOfMoney", required=true) String amountOfMoney, 
	        @RequestParam(value="customerCode", required=true) String customerCode,
	        @RequestParam(value="invoiceNo", required=true) String invoiceNo,
	        @RequestParam(value="VAT", required=true) String VAT
	        ) {
		 String userName= principal.getName();
		 
		 if (userName.equals("")) {
		 } else {
			 User currentuser = this.userService.findbyUserName(userName);
			 @SuppressWarnings("deprecation")
			Date date = new Date(dateTime);
			 long cCode = Long.parseLong(customerCode);
			 double money = Double.parseDouble(amountOfMoney);
			 double vat =  Double.parseDouble(VAT);		 
			 this.invoiceService.createInvoice(description, date, money, cCode, invoiceNo, vat, currentuser);	 
	
		 }		
	   }
}
