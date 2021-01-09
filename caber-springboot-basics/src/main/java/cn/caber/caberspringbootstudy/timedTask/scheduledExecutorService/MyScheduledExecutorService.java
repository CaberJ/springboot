package cn.caber.caberspringbootstudy.timedTask.scheduledExecutorService;

import java.util.Date;
import java.util.concurrent.*;

public class MyScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("task ScheduledExecutorService " + new Date());
            }
        };

        // 参数：1、任务体 2、首次执行的延时时间  3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(runnable,0,3,TimeUnit.SECONDS);
    }

}
