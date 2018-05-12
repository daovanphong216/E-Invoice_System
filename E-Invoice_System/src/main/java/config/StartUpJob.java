package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import model.Account;
import service.AccountService;
import service.InvoiceTypeServiceImp;

@Component
public class StartUpJob implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	@Qualifier("accountService")
	AccountService accountService;
	
	@Autowired
	@Qualifier("invoiceTypeService")
	InvoiceTypeServiceImp invoiceTypeService;
	
	
	
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
	   Account account = accountService.findbyUserName("admin");
	   if (account ==null){
		   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		   accountService.create("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN");
	   }
	   
	   
	}
}
