package com.xrq.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;

/**1111
 * Created by user on 2017/7/22.
 */
@Aspect
@Component
public class HttpAspect {

    private  final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.xrq.controller.GirlController.*(..))")
    public void log()
    {
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint)
    {
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        //url
        logger.info("URL={}",request.getRequestURL());
        //method get post
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class-method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("参数={}",joinPoint.getArgs());
        /*logger.info("before");*/
    }
    @After("log()")
    public void doAfter()
    {

        logger.info("after");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object)
    {

      logger.info("RESPONSE={}",object.toString());
    }
}
