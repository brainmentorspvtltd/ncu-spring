package com.brainmentors.apps.annotationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@PropertySource("classpath:config.properties")
@Component
@Scope("singleton")
public class A {
	//@Autowired
	private B b;
	@Value("${key}")
	//@Value("1001")
	private int id;
	public A() {
		System.out.println("A Cons Call ");
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public B getB() {
		return b;
	}

	void fillX(int x){
		b.setX(x);
	}
	@Autowired
	public void setB(B b) {
		//b.setX(1000);
		this.b = b;
	}
	

}
