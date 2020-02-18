package com.brainmentors.apps.configdemo;

public class T {
	private T() {}
	static int m;
	static int n;
	static {
		m = 100;
		n = m * 10;
	}

}
