package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

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
	
}
