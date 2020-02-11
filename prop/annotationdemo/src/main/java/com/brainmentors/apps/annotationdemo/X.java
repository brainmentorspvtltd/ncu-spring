package com.brainmentors.apps.annotationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class X {
	@Autowired
	@Qualifier("m")
	private IY obj;

//	@Autowired
//	@Qualifier("bl")
//	private IY obj2;

	public IY getObj() {
		return obj;
	}

	public void setObj(IY obj) {
		this.obj = obj;
	}
	

}
