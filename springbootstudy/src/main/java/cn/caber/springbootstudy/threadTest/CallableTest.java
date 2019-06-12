package cn.caber.springbootstudy.threadTest;


import java.util.concurrent.Callable;

public class CallableTest implements Callable {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        System.out.println(Thread.currentThread().getName()+"子线程开始计算");
        Thread.sleep(1000);
        for (int i = 0; i <10 ; i++) {
            sum++;
        }
        return sum;
    }
}
