package com.brainmentors.apps.propdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Employee implements ApplicationContextAware,DisposableBean,InitializingBean{
	private int id ;
	private String name;
	private double salary;
	private ApplicationContext ac;
	public void start() {
		
	}
	public void end() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	void getMyBean(){
		Dept dept = (Dept)ac.getBean("dept");
		System.out.println("Dept is "+dept);
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		ac = applicationContext;
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After Bean Object and Setter");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Before Bean Destroy");
		// TODO Auto-generated method stub
		
	}
	

}
