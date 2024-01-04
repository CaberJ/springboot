package cn.caber.springbootstudy.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/8 19:38
 */

@Component
@Aspect
public class AopTest {



    //配置切点
    @Pointcut("execution(* cn.caber.springbootstudy.bean.InitHandle.testAop())")
    private void pt1() {
    }

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置");
    }


}
