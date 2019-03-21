package cn.caber.caberspringbootstudy.timedTask.quartz.configuretion;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;

@Configuration
public class QuartzConfig {

    @Bean(name = "SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        //用于quartz集群,QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        //任务调度监听类
        //factory.setGlobalTriggerListeners(triggerListenerLogMonitor());
        return factory;
    }

    /**
     * quartz初始化监听器
     *
     * @return
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name = "Scheduler")
    public Scheduler scheduler() throws IOException {
        Scheduler scheduler = schedulerFactoryBean().getScheduler();
        return scheduler;
    }

}
