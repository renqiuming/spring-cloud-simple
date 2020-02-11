package com.rqm.springclouddomain1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@Aspect
@Component
public class WebLogAspect {

    /**
     *     @Around("cut1() || cut2()") //在切入点的方法run之前要干的
     * @param joinPoint
     * @throws Throwable
     */
    public void logBeforeController(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before");
        try{
            Object ob = joinPoint.proceed();
        }catch (Exception ex){
            System.out.println("Exception");
        }
        System.out.println("after");
    }

    /**
     *     @Pointcut("execution(public * com.rqm.springclouddomain1.controller..*.*(..))")//切入点描述 这个是controller包的切入点
     */
    public void cut1(){}

    /**
     *     @Pointcut("execution(public * com.rqm.springclouddomain1.controller..*.*(..))")//切入点描述，这个是uiController包的切入点
     */
    public void cut2(){}
}
