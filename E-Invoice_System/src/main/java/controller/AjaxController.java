package controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
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
import model.TypeReport;
import model.User;
import service.AccountService;
import service.EmailService;
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
	@Qualifier("emailService")
	EmailService emailService;
	
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
		 
		 for(InvoiceType i : this.accountService.findbyUserName(userName).getUser().getTypes()) {
			 InvoiceType t = new InvoiceType();
			 t.setId(i.getId());
			 t.setName(i.getName());
			 t.setLogo("/getTypeInfor/"+i.getId());
			 t.setInvoices(i.getInvoices());
			 l.add(t);
		 }
		 if (userName.equals("")) {
			 return null;  
		 } else {
			return l;
		 }		
	   }
	
	@RequestMapping(value = { "/getAllTypeInforByDate/{dateTime}" }, method = RequestMethod.GET)
	public List<InvoiceType> getAllTypeInforByDate(Principal principal, Authentication authentication,
			@PathVariable("dateTime") String dateTime) {
		
		Date date = new Date();
		try {
			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
			
			date = formatter.parse(dateTime+ ", 00:00:00.000");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		 String userName= principal.getName();
		 List<InvoiceType> l = new ArrayList<InvoiceType>();
		 
		 for(InvoiceType i : this.accountService.findbyUserName(userName).getUser().getTypes()) {
			 
			 InvoiceType t = new InvoiceType();
			 t.setId(i.getId());
			 t.setName(i.getName());
			 t.setLogo("/getTypeInfor/"+i.getId());
			 t.setDeleteAble(i.isDeleteAble());
			 t.setInvoices(this.invoiceService.SearchAllByDateTime(date, i, this.accountService.findbyUserName(principal.getName()).getUser())); // search
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
	        @RequestParam(value="amountOfMoney", required=true) double amountOfMoney, 
	        @RequestParam(value="customerCode", required=true) long customerCode,
	        @RequestParam(value="invoiceNo", required=true) String invoiceNo,
	        @RequestParam(value="VAT", required=true) double VAT,
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
			 newinvoice = this.invoiceService.MakeInvoice(description, date, amountOfMoney, customerCode, invoiceNo, VAT, currentuser, typeId);	 
		 }		
		 return newinvoice;
	   }
	
	
	
	@RequestMapping(value = { "/setlimitmoney" }, method = RequestMethod.GET)
	public String setlimitmoney(Principal principal, Authentication authentication,
	        @RequestParam(value="amountOfMoney", required=true) double amountOfMoney
	        ) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
		 } else {
			 User currentuser = this.userService.findbyUserName(userName);
			 currentuser.setLimitedMoney(amountOfMoney);
			 this.userService.update(currentuser);
		 }		
		 return "{status: 'ok'}";
	   }
	
	@RequestMapping(value = { "/getlimitmoney" }, method = RequestMethod.GET)
	public double getlimitmoney(Principal principal, Authentication authentication
	        ) {
		 String userName= principal.getName();
		 double money = 0;
		 if (userName.equals("")) {
		 } else {
			 User currentuser = this.userService.findbyUserName(userName);
			 money = currentuser.getLimitedMoney();
		 }		
		 return money;
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
	
	
	
	
	@RequestMapping(value = { "/getInvoiceById/{id}" }, method = RequestMethod.GET)
	public Invoice getInvoiceById(Principal principal, Authentication authentication,
			@PathVariable("id") long id) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;  
		 } else {
			 return this.invoiceService.findInvoiceByID(id,this.userService.findbyUserName(userName));
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
	
	
	@RequestMapping(value = { "/gettypereport/{year}/{month}" }, method = RequestMethod.GET)
	public Hashtable<String, Double> gettypereport(Principal principal, Authentication authentication,
			@PathVariable("year") int year,
			@PathVariable("month") int month) {
		 String userName= principal.getName();
		 //..........................................
		 return this.userService.findbyUserName(userName).getMoneyTypeReport(year, month);

	   }
	
	
	@RequestMapping(value = { "/gettypereport/{year}/{month}/{date}" }, method = RequestMethod.GET)
	public Set<TypeReport> gettypereport(Principal principal, Authentication authentication,
			@PathVariable("year") int year,
			@PathVariable("month") int month,
			@PathVariable("date") int date) {
		 String userName= principal.getName();
		 //..........................................
		 return this.userService.findbyUserName(userName).getTypeTeport(year, month, date);

	   }
	
	@RequestMapping(value = { "/removeinvoice/{id}" }, method = RequestMethod.GET)
	public Invoice removeinvoice(Principal principal, Authentication authentication,
			@PathVariable("id") long id) {
		 String userName= principal.getName();
		 if (userName.equals("")) {
			 return null;
		 } else {
			 User user = this.userService.findbyUserName(userName);
			 return this.invoiceService.removeInvoice(id, user);
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
		emailService.setTrigger(day+" " + times[0] +" "+ times[1]);
		emailService.doSendEmail(day, times[0], times[1]);
		List<String> response = new ArrayList<String>();
		response.add("success");
		return response;
	}
	
	@RequestMapping(value = { "/createAdmin" }, method = RequestMethod.POST)
	public List<String> createAdmin(Principal principal, Authentication authentication, @RequestParam String username,  @RequestParam String password){ 
		Account account = accountService.findbyUserName(username);
		List<String> response = new ArrayList<String>();
		   if (account ==null){
			   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			   accountService.create(username, passwordEncoder.encode(password), "ROLE_ADMIN");
			   response.add("success");
		   }
		   else {
			  
			   response.add("Admin name duplicated");
		   }
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
	public InvoiceType  createtype(Principal principal, Authentication authentication,
	        @RequestParam(value="file", required=true) String file,
	        @RequestParam(value="name", required=true) String name) {
			
			Account account = this.accountService.findbyUserName(principal.getName());
			InvoiceType response = new InvoiceType();
			if(account.getRole().equals("ROLE_ADMIN")) {
				if(this.invoiceTypeService.findbyInvoiceTypeName(name,userService.findbyUserName("admin"))==null) {
					
					response = this.invoiceTypeService.createTypeByAdmin(name, file);
				}else {

				}
			}else {
				if(this.invoiceTypeService.findbyInvoiceTypeName(name,account.getUser())==null) {
					response = this.invoiceTypeService.createTypeByMember(name, file,account.getUser());
				}else {

				}
				
			}	
			return response;
	   }
	
	
	@RequestMapping(value = { "/deleteTypeByUser" }, method = RequestMethod.POST)
	public InvoiceType  deleteTypeByUser(Principal principal, Authentication authentication,
	        @RequestParam(value="id", required=true) long id) {
	
		User user = userService.findbyUserName(principal.getName());
		InvoiceType it = invoiceTypeService.findbyId(id);	
		it.setLogo("/getTypeInfor/"+ it.getId());
		invoiceTypeService.DeleteInvoiceType(id, user);;
		return it;
	}
	
	@RequestMapping(value = { "/getAllTypesByAdmin" }, method = RequestMethod.GET)
	public List<InvoiceType> getAllTypes(Principal principal, Authentication authentication) {
			User user = userService.findbyUserName("admin");
			List<InvoiceType> its= this.invoiceTypeService.getAll(user);
			 for(InvoiceType i : its) {
				 i.setLogo("/getTypeInfor/"+i.getId());
			 }
			 return its;
	   }
	
	@RequestMapping(value = { "/getAllTypesByUser" }, method = RequestMethod.GET)
	public List<InvoiceType> getAllTypesByUser(Principal principal, Authentication authentication) {
			User user = userService.findbyUserName(principal.getName());
			return this.invoiceTypeService.getAll(user);
	   }
	
	@RequestMapping(value = { "/deleteTypeByAdmin" }, method = RequestMethod.POST)
	public List<String>  deleteTypeByAdmin(Principal principal, Authentication authentication,
	        @RequestParam(value="id", required=true) long id) {
		User user = userService.findbyUserName("admin");
		InvoiceType it = invoiceTypeService.findbyId(id);	
		invoiceTypeService.DeleteInvoiceType(id, user);
		invoiceTypeService.deleteByName(it.getName());
		List<String> response = new ArrayList<String>();
		response.add("success");
		return response;
	}
}
