package service;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Configuration
@EnableScheduling
@ComponentScan
@Service
public class EmailService {
	private static AnnotationConfigApplicationContext CONTEXT = null;

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @Bean
	 public ThreadPoolTaskScheduler taskScheduler() {
	     //org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
	     return new ThreadPoolTaskScheduler();
	 }
    
    public static EmailService getInstance() {
        if (!isValidBean()) {
            CONTEXT = new AnnotationConfigApplicationContext(EmailService.class);
        }

        return CONTEXT.getBean(EmailService.class);
    }
    
    

    public void start(Runnable task, Trigger trigger) throws Exception {
        scheduler.schedule(task,  trigger);
    }


    public void stopAll() {
        scheduler.shutdown();
        CONTEXT.close();
        System.out.println("hihi stop");
    }

    private static boolean isValidBean() {
        if (CONTEXT == null || !CONTEXT.isActive()) {
            return false;
        }

        try {
            CONTEXT.getBean(EmailService.class);
        } catch (NoSuchBeanDefinitionException ex) {
            return false;
        }

        return true;
    }
}
