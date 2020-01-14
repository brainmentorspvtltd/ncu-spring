package com.brain.apps;

public class Course implements ICourse {
	private String name;
	private int duration;
	private int discount;
	private int noOfApply;
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", duration=" + duration + ", discount=" + discount + ", noOfApply=" + noOfApply
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getNoOfApply() {
		return noOfApply;
	}
	public void setNoOfApply(int noOfApply) {
		this.noOfApply = noOfApply;
	}
	

}
