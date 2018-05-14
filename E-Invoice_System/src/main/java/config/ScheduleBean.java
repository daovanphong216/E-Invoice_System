package config;

import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class ScheduleBean {
	private static ThreadPoolTaskScheduler tpts;
	private static ScheduledFuture<?> task;
	public ThreadPoolTaskScheduler getTpts() {
		return tpts;
	}
	public void setTpts(ThreadPoolTaskScheduler tpts) {
		this.tpts = tpts;
		this.tpts.initialize();
	}
	public ScheduledFuture<?> getTask() {
		return task;
	}
	public void setTask(ScheduledFuture<?> task) {
		this.task = task;
	}
}
