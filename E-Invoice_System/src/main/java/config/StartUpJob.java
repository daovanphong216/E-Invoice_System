package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import model.Account;
import service.AccountService;
import service.InvoiceTypeServiceImp;
import service.UserService;

@Component
public class StartUpJob implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	@Qualifier("accountService")
	AccountService accountService;
	
	@Autowired
	@Qualifier("invoiceTypeService")
	InvoiceTypeServiceImp invoiceTypeService;
	

	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
	   Account account = accountService.findbyUserName("admin");
	   if (account ==null){
		   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		   
		   this.userService.createAdmin("admin", passwordEncoder.encode("admin"), "Default admin", "000000000", "admin@admin", "HCM city");
		  // accountService.create("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN");
	   	}
	     
	   
	}
}
