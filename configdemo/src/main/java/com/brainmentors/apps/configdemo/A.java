package com.brainmentors.apps.configdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class A {
	@Autowired
	@Qualifier("obj")
	private IB obj;

	public IB getObj() {
		return obj;
	}

	public void setObj(IB obj) {
		this.obj = obj;
	}
	
	

}
