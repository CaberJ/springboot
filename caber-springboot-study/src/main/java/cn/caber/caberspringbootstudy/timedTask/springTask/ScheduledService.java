package cn.caber.caberspringbootstudy.timedTask.springTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 最简单的使用方式，在application类上加@EnableScheduling注解，就可以读取到方法里的@Scheduled注解
 */
@Slf4j
@Component
public class ScheduledService {


    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }

    //上一次开始执行时间点后5秒再次执行；
    @Scheduled(fixedRate = 5000)
    public void scheduled1() {

        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
    }
    //上一次执行完毕时间点后5秒再次执行；
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        log.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
    }

}
