package com.wzq.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    ThreadLocal<String> methodName = new ThreadLocal<>();

    @Pointcut("execution(public * com.wzq.springboot.service..*.*(..))")
    public void doLog(){

    }

    @Before("doLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        methodName.set(joinPoint.getSignature().getName());
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "doLog()")
    public void doBefore(Object ret) throws Throwable {
        logger.info("Method :" + methodName.get());
        logger.info("RETURN :" + ret);
        logger.info("SPEND TIME :" + (System.currentTimeMillis() - startTime.get()));
    }

}
