package com.brainmentors.apps.configdemo;

import org.springframework.stereotype.Component;

@Component
public class Y {
	public void logical() {
		for(int i = 1; i<=10; i++) {
			System.out.println("Y Logic I is "+i);
		}
	}
}
