package com.cydeo.aspect;


import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    //logger object
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    public void test() {
//        logger.debug("debug our app");
//        logger.info("Info about application");
//    }

//    //Create pointcut (join point)
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut(){};
//
//    //Advice
//    @Before("myPointcut()")
//    public void log(){
//        logger.info("Info log ...........");
//    }


//    //Advice
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log(){
//        logger.info("Info log ...........");
//    }

//  @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPC(){}
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){
//
//      //working with info, we can modify output
//      logger.info("Before-> Method: {}, Arguments {}, Target {}",
//              joinPoint.getSignature(),joinPoint.getArgs(), joinPoint.getTarget()
//      );
//    }
//

//    @Pointcut("within(com.cydeo.controller..*)")
//    public void  anyControllerOperation(){}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation(){}
//
//@Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
//
//      //working with info, we can modify output
//      logger.info("Before-> Method: {}, Arguments {}, Target {}",
//              joinPoint.getSignature(),joinPoint.getArgs(), joinPoint.getTarget()
//      );
//}


//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {
//    }
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        //working with info, we can modify output
//        logger.info("Before-> Method: {}, Arguments {}, Target {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget()
//        );
//    }


//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPointcut() {
//    }
//
//    @Before("loggingAnnotationPointcut()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
//        //working with info, we can modify output
//        logger.info("Before-> Method: {}, Arguments {}, Target {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget()
//        );
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation() {
//    }

//    @AfterReturning(pointcut="afterReturningGetMappingAnnotation()", returning = "result")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result){
//        logger.info("After Returning-> Method: {}, Result: {}",
//                joinPoint.getSignature(), result.toString());
//
//    }

//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")
//    // CourseDTO -> Object   -- this is ok
//    //List<CourseDTO> -> List<Object>  --- U CAN NOT DO THIS for generic classes
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results) {
//        logger.info("After Returning-> Method: {}, Results: {}",
//                joinPoint.getSignature(), results.toString());
//
//    }


//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception) {
//        logger.error("After Throwing -> Method: {}, Exception: {}", joinPoint.getSignature().toShortString(),
//                exception.getMessage());
//    }


    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPointcut() {
    }

    @Around("loggingAnnotationPointcut()")
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint) {

        logger.info("Before -> Method: {} - Parameter {}",
                proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs()

        );
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("After -> Method: {} - Result: {}", proceedingJoinPoint.getSignature(),
                result.toString());
        return result;
    }

}

















