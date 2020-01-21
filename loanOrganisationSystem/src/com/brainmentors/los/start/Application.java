package com.brainmentors.los.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.brainmentors.los.customer.ICustomer;
import com.brainmentors.los.operation.ILOSProcess;
import com.brainmentors.los.utils.Utility;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Before AC ");
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("After AC");
		ILOSProcess process = (ILOSProcess) ac.getBean("process");
		ICustomer customer = (ICustomer) ac.getBean("customer");
		while(true){
			System.out.println("Do you have Application Number or NOt(Enter 0) Press -1 to Exit");
			int applicationNumber=Utility.scanner.nextInt();
			if(applicationNumber==-1) {
				System.out.println("Thanks for Using");
				System.exit(0);
			}
			if(applicationNumber==0) {
//				New Customer
				process.sourcing(customer);
			}
			
			else {
//				Existing Customer
				process.checkStage(applicationNumber);
			}
		}
	}

}
