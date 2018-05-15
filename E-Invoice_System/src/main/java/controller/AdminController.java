package controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Account;
import model.User;
import service.AccountService;
import service.EmailService;

@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("accountService")
	AccountService accountService;
	
	
	@Autowired
	@Qualifier("emailService")
	EmailService emailService;
	
	 @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	   public String adminPage(Model model, Principal principal, Authentication authentication) {
		  // model.addAttribute("trigger", adminService.getTrigger());
		 
		  // console.log()
		   
		   
		   
	       return "forward:/admin/search?username=&status=all&role=user&page=1";  
	   }
	 
	 @RequestMapping(value = { "/admin/search" }, method = RequestMethod.GET)
	   public String adminPageSearch(Model model, Principal principal, Authentication authentication,
			   @RequestParam(value = "username", required = true) String username,
			   @RequestParam(value = "status", required = true) String status,
			   @RequestParam(value = "role", required = true) String role,
			   @RequestParam(value = "page", required = true) int page) {
		   //model.addAttribute("trigger", adminService.getTrigger());
		 if (page==0) {
			 page=1;
		 }
		 int offset=(page-1)*20;;
		 
		 int totalPages = 0, totalResults=0, activeAccount=0, deactiveAccount=0;
		 String roleStr="";
		 
		 
		 
		 if (role.equals("user")) {
			 roleStr="ROLE_MEMBER"; 
			 model.addAttribute("searchAdmin","" );
			 model.addAttribute("searchUser","selected" );
		 }
		 else {
			 roleStr="ROLE_ADMIN";
			 model.addAttribute("searchAdmin","selected" );
			 model.addAttribute("searchUser","" );
		 }
		 
		 
		 
		 switch(status){
			 case "all":
				 model.addAttribute("all","selected" );
				 model.addAttribute("active","" );
				 model.addAttribute("deactive","" );
				 break;
			 case "active":
				 model.addAttribute("all","" );
				 model.addAttribute("active","selected" );
				 model.addAttribute("deactive","" );
				 break;
			 case "deactive":
				 model.addAttribute("all","" );
				 model.addAttribute("active","" );
				 model.addAttribute("deactive","selected" );
				 break;
		 }
		 		 
		 List<Account> searchResults = accountService.searchAccount(username, status, roleStr, offset, 20);
		 String  trigger=emailService.getTrigger();
		 String[] triggers = trigger.split(" ");
		 for (int i=0; i<3; i++){
			 if (triggers[i].length()<2) {
				 triggers[i]="0"+triggers[i];
			 }
		 }
		 model.addAttribute("day",triggers[0] );
		 model.addAttribute("hour",triggers[1] );
		 model.addAttribute("minute",triggers[2] );
		 
		 model.addAttribute("searchResults",searchResults );
		 model.addAttribute("status",status );
		 model.addAttribute("role",role );
		 model.addAttribute("username",username );
		 model.addAttribute("isAdmin",true );
		 
		 totalResults = searchResults.size();
		 for(int i=0; i<totalResults; i++){
			 if (searchResults.get(i).isActive()) {
				 activeAccount++;
			 }else{
				 deactiveAccount++;
			 }
		 }
		 //totalResults=accountService.countAccount("all", roleStr);
		 //activeAccount= accountService.countAccount("active", roleStr);
		 //deactiveAccount=totalResults-activeAccount;
		 if (totalResults > 0) {
			 totalPages =  (int) Math.ceil(((double)totalResults) / 20);
		 } else
		 {
			 totalPages=0;
			 //page=0;
		 }
		 
		 String[] pageValue={"First","Previous","","","","","","Next","Last"};
		 int[] pageState={0,0,0,0,0,0,0,0,0};
		 int[] pageLink={1,page-1,0,0,0,0,0,page+1,totalPages};
		 int activePage=3;
			
			if (totalPages <= 5){
				for (int i=1; i<=totalPages;i++){
					pageValue[i+1] = Integer.toString(i);
				}
				activePage = page+1;
			}else{
				if (page<=3){
					for (int i=1; i<=5;i++){
						pageValue[i+1] = Integer.toString(i);;
					}
					activePage = page+1;
				} else if (page<totalPages-1){
					for (int i=1; i<=5;i++){
						pageValue[i+1] = Integer.toString(page+i-3);
					}
					activePage = 4;
				} else if (page>=totalPages-1){
					for (int i=1; i<=5;i++){
						pageValue[i+1] = Integer.toString(totalPages-5+i);
					}
					activePage = 6 - (totalPages-page);
				}
			}
			
			
			

			switch (totalPages){
			case 0:
				pageState[0]=-1;
				pageState[1]=-1;
				pageState[7]=-1;
				pageState[8]=-1;
				break;
			case 1:
				pageState[0]=-1;
				pageState[1]=-1;
				pageState[7]=-1;
				pageState[8]=-1;
				break;			
			default:
				if (page == 1)
				{
				
					pageState[0]=-1;
					pageState[1]=-1;
				}
				else if(page == totalPages){
					pageState[7]=-1;
					pageState[8]=-1;
				}
				break;
			}
			pageState[activePage] = 1;
			for (int i=2; i<6; i++){
				if (!pageValue[i].equals("")) pageLink[i]=Integer.parseInt(pageValue[i]);
			}
			model.addAttribute("page",page );
			model.addAttribute("pageValue", pageValue);
			model.addAttribute("pageLink", pageLink);
			model.addAttribute("pageState", pageState);
			model.addAttribute("totalResults", totalResults);
			model.addAttribute("activeAccount", activeAccount);
			model.addAttribute("deactiveAccount", deactiveAccount);
		 
		   
	      return "adminPage";  
	   }
	 
	 @RequestMapping(value = "/userinfo/{id}", method = RequestMethod.GET)
		public String userInfo(Model model, @PathVariable("id") String idStr, Principal principal,
				Authentication authentication) {
			
			long id = Long.parseLong(idStr, 10);
			User user = accountService.findbyId(id).getUser();
			if (user == null) {
				return "redirect:/nofounded";
			} else {
					String username = accountService.findbyId(id).getUserName();
					model.addAttribute("user",user);
					model.addAttribute("username",username);
					return "userInfoAdmin";
				
			}
		}
}
