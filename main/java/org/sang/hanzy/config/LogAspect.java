package org.sang.hanzy.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
//切面类
@Aspect
public class LogAspect {
    //切入点
    @Pointcut("execution(* org.sang.hanzy.*.*.*(..))")
    public void pc1(){

    }
    //前置通知
    @Before(value = "pc1()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法就开始执行了。。。。。。");
    }
    //后置通知
    @After(value = "pc1()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法执行结束了。。。。。。");
    }
    //返回通知
    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法返回值为："+result);
    }
    //异常通知
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterReturning(JoinPoint jp,Exception e){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法抛异了，异常是："+e);
    }
    //环绕通知
    @Around("pc1()")
    public Object acround(ProceedingJoinPoint pjp) throws Throwable{
        return pjp.proceed();
    }

}
