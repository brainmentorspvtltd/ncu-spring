package com.brainmentors.apps.autowire;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class A implements ApplicationContextAware{
	
	private B b; // Instance Level
	//private B b1; // single object injection 
	//private C c;
	//private Set<C> clist; // collection injection
	//private Map<String, Integer> map;
	
	private Map<String,C> map;
	
	
	
//public Map<String, Integer> getMap() {
//		return map;
//	}
//
//	public void setMap(Map<String, Integer> map) {
//		this.map = map;
//	}

public Map<String, C> getMap() {
		return map;
	}

	public void setMap(Map<String, C> map) {
		this.map = map;
	}

public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

//	public List<C> getClist() {
//		return clist;
//	}
//
//	public void setClist(List<C> clist) {
//		this.clist = clist;
//	}

	
//	public B getB1() {
//		return b1;
//	}

//	public Set<C> getClist() {
//		return clist;
//	}
//
//	public void setClist(Set<C> clist) {
//		this.clist = clist;
//	}

//	public void setB1(B b1) {
//		this.b1 = b1;
//	}

//	public C getC() {
//		return c;
//	}
//
//	public void setC(C c) {
//		this.c = c;
//	}

void display()
{
	System.out.println("A  display");
	b.show();
	//b1.show();
//	for(C c : clist) {
//		c.print();
//	}
	System.out.println("Map Loop");
//	for(Map.Entry<String, Integer> m : map.entrySet()) {
//		System.out.println(m.getKey()+" "+m.getValue());
//	}
	for(Map.Entry<String, C> m: map.entrySet()) {
		C obj = m.getValue();
		obj.print();
	}
	System.out.println("Enter the Key");
	Scanner s = new Scanner(System.in);
	String key   = s.next();
	System.out.println("Enter the Value ID ");
	int x = s.nextInt();
	//C c1 = new C(); // Local Level
	C c1 = (C) ac.getBean("c3");
	c1.setX(x);
	map.put(key, c1);
	System.out.println("After Add in Map");
	for(Map.Entry<String, C> m: map.entrySet()) {
		C obj = m.getValue();
		obj.print();
	}
	//c.print();
		
}
private ApplicationContext ac;

@Override
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	// TODO Auto-generated method stub
	this.ac = applicationContext;
	
}
}
