package com.brainmentors.los.operation;

import java.util.ArrayList;

import com.brainmentors.los.customer.Customer;
import com.brainmentors.los.customer.ICustomer;
import com.brainmentors.los.customer.LoanDetails;
import com.brainmentors.los.customer.PersonalInformation;
import com.brainmentors.los.utils.CommonConstants;
import com.brainmentors.los.utils.LoanConstants;
import com.brainmentors.los.utils.StageConstants;
import com.brainmentors.los.utils.Utility;
import static com.brainmentors.los.utils.Utility.scanner;
import static com.brainmentors.los.utils.Utility.serialCounter;


public class LOSProcess implements ILOSProcess,StageConstants,CommonConstants {
	private ArrayList<ICustomer> customers= new ArrayList<>();

	@Override
	public void sourcing(ICustomer customer) {
		// TODO Auto-generated method stub
		customer.setId(serialCounter);
		customer.setStage(SOURCING);
		System.out.println("Enter the First Name");
		String firstName=scanner.next();
		System.out.println("Enter the Last Name");
		String lastName=scanner.next();
		System.out.println("Enter the Age");
		int age=scanner.nextInt();
		System.out.println("Enter the Loan Type HL, AL, PL");
		String type=scanner.next();
		System.out.println("Enter the Amount");
		double amount=scanner.nextDouble();
		System.out.println("Duration of Loan");
		int duration=scanner.nextInt();
		customer.getPersonal().setFirstName(firstName);
		customer.getPersonal().setLastName(lastName);
		customer.getPersonal().setAge(age);
		customer.getLoanDetails().setType(type);
		customer.getLoanDetails().setAmount(amount);
		customer.getLoanDetails().setDuration(duration);
		customers.add(customer);
		serialCounter++;
		System.out.println("Sourcing Done......");
	}
	
	public void qde(ICustomer customer) {
		customer.setStage(QDE);
		System.out.println("Application Number "+customer.getId());
		System.out.println("Name "+customer.getPersonal().getFirstName().toUpperCase()
				+" "+customer.getPersonal().getLastName().toUpperCase());
		System.out.println("You Applied for a "
				+customer.getLoanDetails().getType().toUpperCase()+" Duration "
				+customer.getLoanDetails().getDuration()+" Amount "
				+customer.getLoanDetails().getAmount());
		System.out.println("Enter the PanCard Number ");
		String panCard=scanner.next();
		System.out.println("Enter the VoterId");
		String voterId=scanner.next();
		System.out.println("Enter the Income");
		double income=scanner.nextDouble();
		System.out.println("Enter the Liablity");
		double liablity= scanner.nextDouble();
		System.out.println("Enter the Phone");
		String phone=scanner.next();
		while(phone.length() != 10) {
			System.out.println("Incorrect phone number Plz Enter correct phone number");
			phone = scanner.next();
		}
		System.out.println("Enter the Email");
		String email=scanner.next();
		System.out.println("Enter the state");
		String state = scanner.next();
		System.out.println("Enter the city");
		String city = scanner.next();
		System.out.println("Enter the country");
		String country = scanner.next();
		System.out.println("Enter the pincode");
		String pincode = scanner.next();
		customer.getPersonal().setVoterId(voterId);
		customer.getPersonal().setPanCard(panCard);
		customer.getPersonal().setPhone(phone);
		customer.getPersonal().setEmail(email);
		customer.setIncome(income);
		customer.setLiablity(liablity);
		customer.getAddress().setState(state);
		customer.getAddress().setCity(city);
		customer.getAddress().setCountry(country);
		customer.getAddress().setPincode(pincode);
	}
	
	public void dedupe(ICustomer customer) {
//		System.out.println("Inside Dedupe");
		customer.setStage(DEDUPE);
		boolean isNegtiveFound=false;
		for(Customer negativeCustomer : customer.getNegativeCustomers()) {
			int negativeScore=isNegative(customer, negativeCustomer);
			if(negativeScore>0) {
				System.out.println("Customer Record Found in Dedupe and Score is "+negativeScore);
				isNegtiveFound=true;
				break;
			}
			
		}
		if(isNegtiveFound) {
			System.out.println("Do u Want to Proceed this Loan "+customer.getId());
			char choice=scanner.next().toUpperCase().charAt(0);
			if(choice==NO) {
				customer.setRemarks("Loan is Rejected, Due to High score in Dedupe check");
				customer.setStage(REJECT);
				return;
			}
		}
	}
	
	private int isNegative(ICustomer customer, Customer negative) {
		int percentageMatch=0;
		if(customer.getPersonal().getPhone().equals(negative.getPersonal().getPhone())) {
			percentageMatch+=20;
		}
		if(customer.getPersonal().getEmail().equals(negative.getPersonal().getEmail())) {
			percentageMatch+=20;
		}
		if(customer.getPersonal().getVoterId().equals(negative.getPersonal().getVoterId())) {
			percentageMatch+=20;
		}
		if(customer.getPersonal().getPanCard().equals(negative.getPersonal().getPanCard())) {
			percentageMatch+=20;
		}if(customer.getPersonal().getAge()==negative.getPersonal().getAge()&&customer.getPersonal().getFirstName().equalsIgnoreCase(negative.getPersonal().getFirstName())) {
			percentageMatch+=20;
		}
		return percentageMatch;
	}
	
	public void scoring(ICustomer customer) {
		customer.setStage(SCORING);
		int score=0;
		double totalIncome=customer.getIncome()-customer.getLiablity();
		if(customer.getPersonal().getAge()>=21 && customer.getPersonal().getAge()<=35) {
			score+=50;
			System.out.println("You get 50 points Because of age score");
		}
		if(totalIncome>=200000) {
			score+=50;
			System.out.println("You get 50 points Because of total Income score");
		}
		customer.getLoanDetails().setScore(score);
	}
	
	public void approval(ICustomer customer) {
		customer.setStage(APPROVAL);
		double score=customer.getLoanDetails().getScore();
		System.out.println("id "+customer.getId());
		System.out.println("Name is "+customer.getPersonal().getFirstName().toUpperCase()
				+" "+customer.getPersonal().getLastName().toUpperCase());
		System.out.println("Score is "+customer.getLoanDetails().getScore());
		System.out.println("Loan "+customer.getLoanDetails().getType().toUpperCase()
				+" Amount "+customer.getLoanDetails().getAmount()
				+" Duration "+customer.getLoanDetails().getDuration());
		System.out.println("State "+customer.getAddress().getState().toUpperCase());
	    double approveAmount=customer.getLoanDetails().getAmount() * (score/100);
	    System.out.println("Loan Approve Amount is "+approveAmount);
	    System.out.println("Do u want to Bring this Loan or Not");
	    char choice=scanner.next().toUpperCase().charAt(0);
	    if(choice==NO) {
		customer.setStage(REJECT);
		customer.setRemarks("Customer Deny the Approved Amount " + "" +approveAmount);
		return;
	}
	else {
		showEMI(customer);
	}
	    
}
	
	private void showEMI(ICustomer customer) {
//		System.out.println("EMI is ");
		if(customer.getLoanDetails().getType().equalsIgnoreCase(LoanConstants.HOME_LOAN)) {
			customer.getLoanDetails().setRoi(LoanConstants.HOME_LOAN_ROI);
		}
		if(customer.getLoanDetails().getType().equalsIgnoreCase(LoanConstants.AUTO_LOAN)) {
			customer.getLoanDetails().setRoi(LoanConstants.AUTO_LOAN_ROI);
		}
		if(customer.getLoanDetails().getType().equalsIgnoreCase(LoanConstants.PERSONAL_LOAN)) {
			customer.getLoanDetails().setRoi(LoanConstants.PERSONAL_LOAN_ROI);
		}
		double perMonthPrinciple = customer.getLoanDetails().getAmount()/customer.getLoanDetails().getDuration();
		double interest=perMonthPrinciple * customer.getLoanDetails().getRoi();
		double totalEmi = perMonthPrinciple+interest;
		System.out.println("Your EMI is "+totalEmi);
	}
	

	@Override
	public void checkStage(int applicationNumber) {
		// TODO Auto-generated method stub
		boolean isStageFound=false;
		if(customers!=null && customers.size()>0) {
		for(ICustomer customer:customers) {
			if(customer.getId()==applicationNumber) {
				System.out.println("You are on "+Utility.getStageName(customer.getStage()));
				isStageFound = true;
				moveToNextStage(customer);
				break;
			}
		}
		
	}
		if(!isStageFound) {
			System.out.println("Invalid Application Number");
		}
	}
	
	public void moveToNextStage(ICustomer customer) {
		while(true) {
		if(customer.getStage()==SOURCING) {
			System.out.println("Want to Move to Next Stage Y/N ");
			char choice=scanner.next().toUpperCase().charAt(0);
			if(choice==YES) {
				qde(customer);
			}
			else {
				return;
			}
		}
		else
			if(customer.getStage()==QDE) {
				System.out.println("Want to Move to Next Stage Y/N ");
				char choice=scanner.next().toUpperCase().charAt(0);
				if(choice==YES) {
					dedupe(customer);
				}
				else {
					return;
				}
		}
			else
			if(customer.getStage()==DEDUPE) {
				System.out.println("Dedupe Want to Move to Next Stage Y/N ");
				char choice=scanner.next().toUpperCase().charAt(0);
				if(choice==YES) {
					scoring(customer);
				}
				else {
					return;
				}
		}
		if(customer.getStage()==SCORING) {
			System.out.println("Scoring Want to Move to Next Stage Y/N ");
			char choice=scanner.next().toUpperCase().charAt(0);
			if(choice==YES) {
				approval(customer);
				
			}
			else {
				return;
			}
	}
		if(customer.getStage()==APPROVAL) {
			System.out.println("Your Loan is Approved");
			return;
		}
	}
	}
	
}
