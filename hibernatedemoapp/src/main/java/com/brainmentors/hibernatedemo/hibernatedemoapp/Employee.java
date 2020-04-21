package com.brainmentors.hibernatedemo.hibernatedemoapp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emp_master")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="ename",nullable = false,length = 50,unique = true,insertable = true,updatable = true )
	private String name;
	@Column(name="salary",nullable = false, scale = 10 , precision = 2)
	private double salary;
	@Temporal(TemporalType.TIMESTAMP)
	private Date doj;
	Employee(){
		
	}
	Employee(String name, double salary, Date doj){
		this.name = name;
		this.salary = salary;
		this.doj = doj;
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
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	

}
