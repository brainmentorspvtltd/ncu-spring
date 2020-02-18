package com.brainmentors.apps.configdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class PerformanceAspect {
	long startTime;
	@Pointcut("execution(public void logic*())")
	public void pointCutMethod() {
		
	}
	
	@Before("pointCutMethod()")
	public void start(JoinPoint jp) {
		startTime = System.currentTimeMillis();
		System.out.println("Start Time is "+startTime+" "+jp.getSignature());
	}
	@After("pointCutMethod()")
	public void end(JoinPoint jp) {
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime)+" ms"+" "+jp.getSignature());
	}
}
