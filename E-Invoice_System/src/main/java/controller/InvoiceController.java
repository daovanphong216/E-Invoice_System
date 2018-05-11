package controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.Invoice;
import model.User;
import service.InvoiceService;
import service.InvoiceTypeService;
import service.UserService;




@Controller
public class InvoiceController {
	@Autowired
	 @Qualifier("userService")
	 UserService userService;
	@Autowired
	 @Qualifier("invoiceService")
	 InvoiceService invoiceService;
	
	@Autowired
	 @Qualifier("invoiceTypeService")
	InvoiceTypeService invoiceTypeService;
	
	
	@RequestMapping(value = { "/createtype" }, method = RequestMethod.POST)
	public String createtype(Principal principal, Authentication authentication,
		
	        @RequestParam(value="file", required=true) MultipartFile file
	        ) {
	
			try {
				System.out.println(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		 return "addtype";
	   }
	@RequestMapping(value = { "/addtype" }, method = RequestMethod.GET)
	public String addtype(Principal principal, Authentication authentication
	        ) 		{
		 return "addtype";
	   }
	
	
	
}
