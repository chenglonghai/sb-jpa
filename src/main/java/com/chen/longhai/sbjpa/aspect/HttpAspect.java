package com.chen.longhai.sbjpa.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

@Aspect
@Component
public class HttpAspect {

	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	@Pointcut("execution (public * com.chen.longhai.sbjpa.controller.HelloController.*(..))")
	public void log(){
		System.out.println("公用方法");
	}
	
	@Before("log()")
	public void beforeLog(JoinPoint joinPoint){
   ServletRequestAttributes attributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    HttpServletRequest request =  attributes.getRequest();
		logger.info("调用方法前");
		//url
		logger.info("url={}",request.getRequestURL());
		
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		//类方法
		logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName());
		//参数
		logger.info("args={}",joinPoint.getArgs());
		
		
		
	}
	@After("log()")
	public void afterLog(){
		logger.info("调用方法后");
	}
	
	//获取返回的内容
	@AfterReturning(pointcut="log()", returning = "object")
	public void doAfterReturnning(Object object) {
		logger.info("response={}",object);
	}
	
	
}
