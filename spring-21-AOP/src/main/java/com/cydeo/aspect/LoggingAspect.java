package com.cydeo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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


    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPointcut() {
    }

    @Before("loggingAnnotationPointcut()")
    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
        //working with info, we can modify output
        logger.info("Before-> Method: {}, Arguments {}, Target {}",
                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget()
        );
    }


}

















