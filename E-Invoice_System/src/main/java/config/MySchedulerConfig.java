package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class MySchedulerConfig {

	/* @Bean
	 public ThreadPoolTaskScheduler taskScheduler() {
	     //org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
	     return new ThreadPoolTaskScheduler();
	 }*/
}