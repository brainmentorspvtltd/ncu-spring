package com.brainmentors.apps.configdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackages = "com.brainmentors")
public class ConfigBeans {
	
	@Bean("obj")
	public IB giveBObject(){
		IB obj = new B(T.m + T.n);
		obj.calc();
		return obj;
	}
	@Bean("obj2")
	public IB giveBObject2(){
		IB obj = new C();
		
		return obj;
	}
	

}
