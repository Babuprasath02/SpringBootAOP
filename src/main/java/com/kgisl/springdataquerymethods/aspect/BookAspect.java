package com.kgisl.springdataquerymethods.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Before("execution(* com.kgisl.springdataquerymethods.service.*.*(..))")
    public void beforelog(JoinPoint point) {
        LOGGER.info("-----------------------@Before advice called--------------------------------------");
        LOGGER.debug("Class Name :  " + point.getSignature().getDeclaringTypeName());
        LOGGER.info("Entering in Method :  " + point.getSignature().getName());
        LOGGER.warn("Argumentsttt :  " + Arrays.toString(point.getArgs()));
    }
    @Pointcut("execution(* com.kgisl.springdataquerymethods.service.*.*(..))")
    public void controller() {
    }
    @Pointcut("execution(* com.kgisl.springdataquerymethods.service.*.*(..))")
    protected void allMethod() {
    }

    @AfterReturning(pointcut = "within(@org.springframework.stereotype.Service *)", returning = "result")
public void logAfterReturning(JoinPoint joinPoint, Object result) {
    LOGGER.info("------------------- @AfterReturning advice called ---------------------------------");
    LOGGER.info(" >Returning for class : {} ; Method : {} "+ joinPoint.getTarget().getClass().getName()+
            joinPoint.getSignature().getName());
    if (result != null) {
        LOGGER.info("> with value : {}" + result.toString());
    } else {
        LOGGER.info(">with null as return value.");
    }
}
@AfterThrowing(pointcut = "within(@org.springframework.stereotype.Service *||@org.springframework.stereotype.Controller * )", throwing = "exception")
public void logAfterThrowing(JoinPoint joinPoint, Throwable exception)throws Throwable {
    System.out.println("++++++++++++please enter into throwing+++++++++++++");
    LOGGER.info("-------------------@AfterThrowing advice called -----------------------------------");
    LOGGER.error(">>Exception Thrown: " + exception);
    LOGGER.error(">>Inside CatchThrowException.afterThrowing() method...");
    LOGGER.error(">>Running after throwing exception...");
  
}
@AfterThrowing(pointcut="execution(* com.kgisl.springdataquerymethods.controller.*.*(..))", 
        throwing="excep")
        public void afterThrowing(JoinPoint joinPoint, Throwable excep) throws Throwable {
            LOGGER.info("------------------ @AFter Throwing advice called ----------------------------------------");
            LOGGER.error(">>Exception Illegal Arithmetic Exception argument:: " + excep);
            System.out.println("Inside CatchThrowException.afterThrowing() method...");
            System.out.println("Running after throwing exception...");
            System.out.println("Exception : " + excep);
           
        }
    
}
