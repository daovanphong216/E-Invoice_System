package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.DefaultPropertiesPersister;

import config.AppProp;

@Service
public class AdminService {
	@Autowired
	private Environment env;
	
	@Autowired
	@Qualifier("AppProp")
	AppProp appProp;
	
	@Autowired
	@Qualifier("emailService")
	EmailService emailService;
	
	public void doSendEmail(String day, String hour, String minute) throws Exception{
		String triggerStr= "0 " + minute + " " + hour + " " + day + " * ?";
		System.out.println(triggerStr);
		Trigger trigger = new CronTrigger(triggerStr);
		Runnable task = new SendEmailJob();
	   //	EmailService.getInstance().stopAll();
	   //	EmailService.getInstance().start(task, trigger);
	}
	
	public String getTrigger(){
		return appProp.getTrigger();
	}
	
	public void setTrigger(String trigger)  {
		appProp.setTrigger(trigger);
	}
	
}
