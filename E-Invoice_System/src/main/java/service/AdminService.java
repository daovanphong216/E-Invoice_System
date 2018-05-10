package service;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;



@Service
@PropertySource("classpath:TriggerTime.properties")
public class AdminService {
	@Autowired
	private Environment env;
	
	
	public void doSendEmail(String triggerStr) throws Exception{
		Trigger trigger = new CronTrigger(triggerStr);
		Runnable task = new SendEmailJob();
	   	EmailService.getInstance().stopAll();
	   	EmailService.getInstance().start(task, trigger);
	}
	
	public String getTrigger(){
		return env.getProperty("system.trigger");
	}
	
	public void setTrigger(String trigger) throws ConfigurationException{
		PropertiesConfiguration config = new PropertiesConfiguration("classpath:TriggerTime.properties");
		config.setProperty("system.trigger", trigger);
		config.save();
	}
	
}
