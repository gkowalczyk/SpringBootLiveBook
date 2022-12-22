package com.example.springbootlivebook.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class HelloAspect {


    @Around("execution(* com.example.springbootlivebook.AOP.SayHello.sayHelloo(..))")
    public void aroundHello(ProceedingJoinPoint proceedingJointPoint) throws Throwable {
        System.out.println("aroundHello");
        proceedingJointPoint.proceed();
    }

    @Before("execution(* com.example.springbootlivebook.AOP.SayHello.sayHelloo(..))")
    public void beforeHello() {
        System.out.println("beforeHello");

    }

    @After("execution(* com.example.springbootlivebook.AOP.SayHello.sayHelloo(..))")
    public void afterHello() {
        System.out.println("afterHello");
    }
}
