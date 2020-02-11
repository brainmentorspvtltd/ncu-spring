package com.brainmentors.apps.annotationdemo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("m")
@Scope("prototype")
@Primary
public class Y implements IY {
	public Y() {
		System.out.println("Y Object");
	}

	@Override
	public void emi() {
		// TODO Auto-generated method stub
		System.out.println("Monthly");
	}

}
