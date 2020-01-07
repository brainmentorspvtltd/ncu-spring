package com.brainmentors.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring.xml");
		IProducer producer = (IProducer)ac.getBean("obj");
		producer.first();
	}

}
