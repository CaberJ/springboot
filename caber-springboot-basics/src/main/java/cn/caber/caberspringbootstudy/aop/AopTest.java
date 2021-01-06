package cn.caber.caberspringbootstudy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
    private final static Logger logger = LoggerFactory.getLogger(AopTest.class);


    //配置切点
    @Pointcut("execution(* cn.caber.caberspringbootstudy.service.serviceImpl.HelloServiceImpl.*(..))")
    private void pt1() {
    }

    @Pointcut("@annotation(cn.caber.caberspringbootstudy.annotation.TimeConsumingPrint)")
    private void pt2() {
    }

    /**
     * 前置通知
     */
//    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     * 问题：
     * 当配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     * 通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而代码中没有。
     * 解决：
     * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     * 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会提供该接口的实现类供我们使用。
     * <p>
     * spring中的环绕通知：
     * 它是spring框架提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    @Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
        /*    System.out.println("ProceedingJoinPoint:"+pjp);
            System.out.println("ProceedingJoinPoint:"+pjp.toLongString());
            System.out.println("ProceedingJoinPoint:"+pjp.toShortString());
            System.out.println("ProceedingJoinPoint:"+pjp.toString());
            System.out.println("ProceedingJoinPoint:"+pjp.getKind());
            System.out.println("ProceedingJoinPoint:"+pjp.getArgs());
            System.out.println("ProceedingJoinPoint:"+pjp.getSignature());
            System.out.println("ProceedingJoinPoint:"+pjp.getSourceLocation());
            System.out.println("ProceedingJoinPoint:"+pjp.getStaticPart());
            System.out.println("ProceedingJoinPoint:"+pjp.getThis());
            System.out.println("ProceedingJoinPoint:"+pjp.getClass());*/
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");

            return rtValue;
        } catch (Throwable t) {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }

    @Around("pt2()")
    public Object timeConsumingPrint(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            long begin = System.currentTimeMillis();
            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）
            long end = System.currentTimeMillis();
            long consume = end - begin;
            logger.info("执行耗时：" + pjp.toShortString() + ":" + consume + "ms");
            return rtValue;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

}
