package com.brainmentors.apps.annotationdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bl")
@Scope("prototype")
public class Z implements IY {
	public Z() {
		System.out.println("Z Object");
	}

	@Override
	public void emi() {
		// TODO Auto-generated method stub
		System.out.println("Ballon ");
	}

}
