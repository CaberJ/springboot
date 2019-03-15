package cn.caber.caberspringbootstudy.timedTask.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task run "+new Date());
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,10,3000);

    }
}
