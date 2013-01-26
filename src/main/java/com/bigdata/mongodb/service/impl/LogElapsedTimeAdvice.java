package com.bigdata.mongodb.service.impl;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 
 */
@Component("logElapsedTimeAdvice")
@Aspect
public class LogElapsedTimeAdvice {

    private static final Logger LOG = Logger.getLogger(LogElapsedTimeAdvice.class);

    @Around("execution(* com.bigdata.mongodb.service.impl.DataLoaderImpl.loadData(..))")
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("Before invoking " + joinPoint.getTarget().getClass() + "."
                + joinPoint.getSignature().getName());
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();

        joinPoint.proceed();

        stopwatch.stop();
        LOG.info(stopwatch.shortSummary());
        LOG.info("After invoking " + joinPoint.getTarget().getClass() + "."
                + joinPoint.getSignature().getName());
    }

}
