package com.brainmentors.los.customer;

import java.util.ArrayList;

public interface ICustomer {
	public void setId(int id);
	public void setIncome(double income);
	public void setLiablity(double liablity);
	public void setStage(int stage);
	public void setRemarks(String remarks);
	public PersonalInformation getPersonal();
	public LoanDetails getLoanDetails();
	public Address getAddress();
	public int getId();
	public int getStage();
	public double getIncome();
	public double getLiablity();
	public ArrayList<Customer> getNegativeCustomers();
}
