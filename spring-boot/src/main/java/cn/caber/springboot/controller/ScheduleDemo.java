package cn.caber.springboot.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDemo {

    @Scheduled(cron = "${schedule.customer.followStatus}")
    public void scheduled() {
        System.out.println("=====>>>>>使用cron  {"+ System.currentTimeMillis()+"}");
    }
}
