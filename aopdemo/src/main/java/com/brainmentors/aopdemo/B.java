package com.brainmentors.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class B {
	public void print2() {
		System.out.println("B Class Print");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B  Ends");
	}
}
