package com.hanains.jblog.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class MyAspect {
	//execution( 접근자, 반환타입, 패키지.클래스(인터페이스).메소드(인수) throw 예외.
	
	StopWatch stopWatch;
	
	@Before("execution( * com.hanains.jblog.dao.BlogDao.getBlogList(..))")
	public void before(){
		System.out.println("...");
		stopWatch = new StopWatch("Blog Dao Watch");
		stopWatch.start("init");
		System.out.println("My BlogDao Aspect.Before Called");
		
	}
	@After("execution( * com.hanains.jblog.dao.BlogDao.getBlogList(..))")
	public void after(){
		System.out.println("My BlogDao Aspect.after Called");
		stopWatch.stop();
		System.out.println("took:"+stopWatch.getLastTaskTimeMillis()+"ms");
		System.out.println(stopWatch.toString());
		System.out.println("=============================================");
		//System.out.println(stopWatch.prettyPrint());
	}
	
	public Object round(ProceedingJoinPoint pjp)throws Throwable{
		
		return null;
	}
	
	public void afterRetuning(){
		
	}
	
	public void afterThrowable(){
		
	}
}
