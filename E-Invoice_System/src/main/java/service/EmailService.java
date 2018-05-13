package service;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import config.AppProp;
import config.ScheduleBean;




@Service
public class EmailService {
	@Autowired
	@Qualifier("ScheduleBean")
	ScheduleBean scheduleBean;
		
	@Autowired
	@Qualifier("AppProp")
	AppProp appProp;
	
	
	public void doSendEmail(String day, String hour, String minute) throws Exception{
		String triggerStr= "0 " + minute + " " + hour + " " + day + " * ?";
		Trigger trigger = new CronTrigger(triggerStr);
		Runnable task = new SendEmailJob();
		if (scheduleBean.getTask()!=null){
			scheduleBean.getTask().cancel(true);
		}
		scheduleBean.setTpts(new ThreadPoolTaskScheduler());
		scheduleBean.setTask(scheduleBean.getTpts().schedule(task,trigger));
//		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(System.g.availableProcessors());
		//emailService.stopAll();
		//emailService.start(task, trigger);
	}
	
	public String getTrigger(){
		return appProp.getTrigger();
	}
	
	public void setTrigger(String trigger)  {
		appProp.setTrigger(trigger);
	}
	
}
