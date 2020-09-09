package cn.caber.springboot.async.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class  MyAsyncConfigurer implements AsyncConfigurer {

    @Value("${task.poolSize}")
    private Integer taskPoolSize;

    @Value("${task.aliveSeconds}")
    private Integer taskAliveSeconds;

    @Value("${task.maxPoolSize}")
    private Integer taskMaxPoolSize;

    @Bean(name = "myAsyncExecutor")
    @Override
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(taskPoolSize == null ? 10 : taskPoolSize);
        threadPoolTaskExecutor.setKeepAliveSeconds(taskAliveSeconds == null ? 30 : taskAliveSeconds);
        threadPoolTaskExecutor.setMaxPoolSize(taskMaxPoolSize == null ? 30 :taskMaxPoolSize);
        threadPoolTaskExecutor.setThreadNamePrefix("caber_task_");
        return threadPoolTaskExecutor;
    }
}
