package com.brainmentors.los.customer;

import java.util.ArrayList;

public class Customer implements ICustomer {
	private int id;
	PersonalInformation personal;
	private Address address;  //Has -A RelationShip
	private double income;
	private double liablity;
	private LoanDetails loanDetails;
	private int stage;
	private String remarks;
	private ArrayList<Customer> negativeCustomers;
	public ArrayList<Customer> getNegativeCustomers() {
		return negativeCustomers;
	}
	public void setNegativeCustomers(ArrayList<Customer> negativeCustomers) {
		this.negativeCustomers = negativeCustomers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PersonalInformation getPersonal() {
		return personal;
	}
	public void setPersonal(PersonalInformation personal) {
		this.personal = personal;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getLiablity() {
		return liablity;
	}
	public void setLiablity(double liablity) {
		this.liablity = liablity;
	}
	public LoanDetails getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(LoanDetails loanDetails) {
		this.loanDetails = loanDetails;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
