package controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Account;
import model.Invoice;
import model.InvoiceType;
import model.User;
import service.AccountService;
import service.AdminService;
import service.InvoiceService;
import service.InvoiceTypeService;
import service.UserService;

@RestController
public class AjaxController {
	@Autowired
	 @Qualifier("userService")
	 UserService userService;
	
	@Autowired
	 @Qualifier("accountService")
	 AccountService accountService;
	
	@Autowired
	 @Qualifier("adminService")
	 AdminService adminService;
	
	@Autowired
	 @Qualifier("invoiceService")
	 InvoiceService invoiceService;
	
	@Autowired
	 @Qualifier("invoiceTypeService")
	 InvoiceTypeService invoiceTypeService;

	class SimpleResponse{
		String message;
		SimpleResponse(String msg){
			message=msg;
		}
	}
	
	@RequestMapping(value = { "/getInvoiceFromUser" }, method = RequestMethod.GET)
	public Set<Invoice> getInvoiceFromUser(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return this.userService.findbyUserName(userName).getInvoices();
		 }		
	   }
	
	@RequestMapping(value = { "/getAllTypeInfor" }, method = RequestMethod.GET)
	public List<InvoiceType> getAllInvoiceType(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 List<InvoiceType> l = new ArrayList<InvoiceType>();
		 
		 for(InvoiceType i : this.invoiceTypeService.getAll()) {
			 InvoiceType t = new InvoiceType();
			 t.setId(i.getId());
			 t.setName(i.getName());
			 t.setLogo("/getTypeInfor/"+i.getId());
			 l.add(t);
		 }
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return l;
		 }		
	   }
	
	
	
	
	@RequestMapping(value = { "/CreateInvoice" }, method = RequestMethod.GET)
	public String createInvoice(Principal principal, Authentication authentication,
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
			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
			 Date date = new Date();
			try {
				date = formatter.parse(dateTime+ ", 00:00:00.000");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 long cCode = Long.parseLong(customerCode);
			 double money = Double.parseDouble(amountOfMoney);
			 double vat =  Double.parseDouble(VAT);		 
			 this.invoiceService.createInvoice(description, date, money, cCode, invoiceNo, vat, currentuser);	 
		 }		
		 return "{'msg': 'success'}";
	   }
	
	@RequestMapping(value = { "/makeInvoice" }, method = RequestMethod.GET)
	public Invoice makeInvoice(Principal principal, Authentication authentication,
			@RequestParam(value="description", required=true) String description, 
	        @RequestParam(value="dateTime", required=true) String dateTime, 
	        @RequestParam(value="amountOfMoney", required=true) String amountOfMoney, 
	        @RequestParam(value="customerCode", required=true) String customerCode,
	        @RequestParam(value="invoiceNo", required=true) String invoiceNo,
	        @RequestParam(value="VAT", required=true) String VAT,
	        @RequestParam(value="type", required=true) long typeId
	        ) {
		 String userName= principal.getName();
		 Invoice newinvoice = null;
		 if (userName.equals("")) {
		 } else {
			 User currentuser = this.userService.findbyUserName(userName);
			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
			 Date date = new Date();
			try {
				date = formatter.parse(dateTime+ ", 00:00:00.000");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 long cCode = Long.parseLong(customerCode);
			 double money = Double.parseDouble(amountOfMoney);
			 double vat =  Double.parseDouble(VAT);		 
			 newinvoice = this.invoiceService.MakeInvoice(description, date, money, cCode, invoiceNo, vat, currentuser, typeId);	 
		 }		
		 return newinvoice;
	   }
	
	@RequestMapping(value = { "/getInvoiceFromUser/{dateTime}" }, method = RequestMethod.GET)
	public Set<Invoice> getInvoiceFromUser(Principal principal, Authentication authentication,
			@PathVariable("dateTime") String dateTime) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			 Date date = new Date();
				try {
					 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
					
					date = formatter.parse(dateTime+ ", 00:00:00.000");
					 System.out.println(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			return this.userService.findbyUserName(userName).getInvoices(date);
		 }		
	   }
	
	
	@RequestMapping(value = { "/getreport/{year}/{month}" }, method = RequestMethod.GET)
	public double[] getreport(Principal principal, Authentication authentication,
			@PathVariable("year") int year,
			@PathVariable("month") int month) {
		 String userName= principal.getName();
	
			return this.userService.findbyUserName(userName).getMoneyReport(year,month);

	   }
	
	@RequestMapping(value = { "/getreport/{year}" }, method = RequestMethod.GET)
	public double[] getreport(Principal principal, Authentication authentication,
			@PathVariable("year") int year) {
		 String userName= principal.getName();
	
			return this.userService.findbyUserName(userName).getMoneyReport(year);

	   }
	
	
	@RequestMapping(value = { "/removeinvoice/{id}" }, method = RequestMethod.GET)
	public String removeinvoice(Principal principal, Authentication authentication,
			@PathVariable("id") long id) {
		System.out.println(id);
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return "{'msg': 'fail'}";  
		 } else {
			 User user = this.userService.findbyUserName(userName);
			 this.invoiceService.remove(id, user);
			 return "{'msg': 'success'}";  
		 }		
	   }
	
	
	@RequestMapping(value = { "/getAllUsers" }, method = RequestMethod.GET)
	public List<User> getAllUser(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return this.userService.getAll();
		 }		
	   }
	
	@RequestMapping(value = { "/searchAccount" }, method = RequestMethod.POST)
	public List<Account> searchUser(Principal principal, Authentication authentication, @RequestParam String username, 
			@RequestParam String type, @RequestParam String role, @RequestParam String page) {
		//System.out.println(username + type);
		String roleStr="";
		 int pageInt=Integer.parseInt(page);
		 int offset=  (pageInt-1)*2;
		 if (role.equals("user")) {
			 roleStr="ROLE_MEMBER"; 
		 }
		 else {
			 roleStr="ROLE_ADMIN";
		 }
		return this.accountService.searchAccount(username, type, roleStr, offset,20);
				
	   }

	
	@RequestMapping(value = { "/updateActive" }, method = RequestMethod.POST)
	public List<String> updateActive(Principal principal, Authentication authentication, String id, 
			@RequestParam String status) {
		long idL = Long.parseLong(id, 10);
		boolean newStatus=false;
		if (status.equals("deactive")) {
			newStatus=true;
		}
		//System.out.println(username + type);
		accountService.updateActive(idL, newStatus);
		List<String> response = new ArrayList<String>();
		response.add("success");
		return response;
	}
	
	@RequestMapping(value = { "/updateTrigger" }, method = RequestMethod.POST)
	public List<String> updateTrigger(Principal principal, Authentication authentication, @RequestParam String day, @RequestParam String time) throws Exception{ 
		String[] times = time.split(":");
		adminService.setTrigger(day+" " + times[0] +" "+ times[1]);
		//adminService.doSendEmail(day, times[0], times[1]);
		List<String> response = new ArrayList<String>();
		response.add("success");
		return response;
	}
	
	@RequestMapping(value = { "/createAdmin" }, method = RequestMethod.POST)
	public List<String> createAdmin(Principal principal, Authentication authentication, @RequestParam String username,  @RequestParam String password){ 
		Account account = accountService.findbyUserName(username);
		   if (account ==null){
			   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			   accountService.create(username, passwordEncoder.encode(password), "ROLE_ADMIN");
		   }
		List<String> response = new ArrayList<String>();
		response.add("success");
		return response;
	}
	
	@RequestMapping(value = { "/getAllAdmins" }, method = RequestMethod.GET)
	public List<Account> getAllAdmins(Principal principal, Authentication authentication) {
			return this.accountService.getAllAdmins();	
	   }
	
	@RequestMapping(value = { "/getAllAccounts" }, method = RequestMethod.GET)
	public List<Account> getAllAccount(Principal principal, Authentication authentication) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return this.userService.getAllAccount();
		 }		
	   }
	
	@RequestMapping(value = { "/updateInfo" }, method = RequestMethod.POST)
	public List<String> updateInfo(Principal principal, Authentication authentication, 
			@RequestParam String username,  
			@RequestParam String password,
			@RequestParam String email,
			@RequestParam String name,
			@RequestParam String address,
			@RequestParam String phoneNumber){ 
		
		Account account = accountService.findbyUserName(username);
		if (account !=null){
			   User user = account.getUser();
			   user.setEmail(email);
			   user.setName(name);
			   user.setAddress(address);
			   user.setPhoneNumber(phoneNumber);
			   userService.update(user);
			   
			   if (password!=null && !password.equals("")){
				   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				   account.setHashPassword(passwordEncoder.encode(password));
				   accountService.update(account);
			   }
		   }
		List<String> response = new ArrayList<String>();
		response.add("success");
		return response;
	}
	
	@RequestMapping(value = { "/createtype" }, method = RequestMethod.POST)
	public List<String>  createtype(Principal principal, Authentication authentication,
	        @RequestParam(value="file", required=true) String file,
	        @RequestParam(value="name", required=true) String name) {
			this.invoiceTypeService.create(name, file);
		 	
			List<String> response = new ArrayList<String>();
			response.add("success");
			return response;
	   }
}
