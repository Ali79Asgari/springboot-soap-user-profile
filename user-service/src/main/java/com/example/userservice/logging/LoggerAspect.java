package com.example.userservice.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Pointcut("within(@org.springframework.stereotype.Service *) || within(@org.springframework.web.bind.annotation.RestController *)")
    public void serviceAndControllerMethods() {
    }

    @Before("serviceAndControllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("➡️  Entering method: {} with args: {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "serviceAndControllerMethods()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("✅  Completed method: {} with result: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "serviceAndControllerMethods()", throwing = "ex")
    public void logError(JoinPoint joinPoint, Throwable ex) {
        log.error("❌  Exception in method: {} => {}", joinPoint.getSignature(), ex.getMessage(), ex);
    }

    @Around("serviceAndControllerMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;
            log.info("⏱️  Executed {} in {} ms", joinPoint.getSignature(), duration);
            return result;
        } catch (Throwable t) {
            logError(joinPoint, t);
            throw t;
        }
    }
}
