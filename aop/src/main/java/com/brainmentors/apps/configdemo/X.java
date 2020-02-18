package com.brainmentors.apps.configdemo;

import org.springframework.stereotype.Component;

@Component
public class X {
	public void logic() {
		for(int i = 1; i<=10; i++) {
			System.out.println("X Logic I is "+i);
		}
	}

}
