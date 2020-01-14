package com.brain.apps;

class SingleTon{
	private static SingleTon obj;
	private SingleTon() {
		System.out.println("Cons Call");
	}
	static SingleTon getObject(){
		if(obj==null) {
			obj = new SingleTon();
		}
		return obj;
	}
}

public class SingletonDemo {

	public static void main(String[] args) {
		SingleTon s1 = SingleTon.getObject();
		SingleTon s2 = SingleTon.getObject();
		SingleTon s3 = SingleTon.getObject();
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();
		Runtime r3 = Runtime.getRuntime();
		System.out.println(r1==r2);
		System.out.println(r1==r3);
		// TODO Auto-generated method stub

	}

}
