package com.brain.apps;

public class Student {
	private int id;
	private String name;
	private String course;
	private double fees;
	private ICourse courseObj;
	
	public ICourse getCourseObj() {
		return courseObj;
	}
	public void setCourseObj(ICourse courseObj) {
		this.courseObj = courseObj;
	}
	@Override
	public int hashCode() {
		return name.length();
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", fees=" + fees + ", courseObj="
				+ courseObj + "]";
	}
	Student(int id , String name, String course, double fees){
		System.out.println("Student Param Cons Call");
		this.id = id;
		this.name = name;
		this.course = course;
		this.fees = fees;
		//System.out.println("Student Cons Call");
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	

}
