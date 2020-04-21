package com.brainmentors.testengine.models.user;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Student {
	@NotEmpty(message="Name is Required")
	private String name;
	
	@Min(value = 18,message = "Min is 18")
	@Max(value = 26,message = "Max is 26")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
