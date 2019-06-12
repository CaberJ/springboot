package cn.caber.springbootstudy.threadTest;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableImpl {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CallableTest callableTest = new CallableTest();
        CountDownLatch countDownLatch = new CountDownLatch(5);

        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Future future = null;
            try {
                future = executorService.submit(callableTest);
                countDownLatch.countDown();
            } catch (Exception e) {
                countDownLatch.countDown();
                e.printStackTrace();
            }
            Integer o = (Integer) future.get();
                list.add(o);
        }
        countDownLatch.await();
        System.out.println(list.toString());


    }
}
