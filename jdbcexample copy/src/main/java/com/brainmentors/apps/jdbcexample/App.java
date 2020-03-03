package com.brainmentors.apps.jdbcexample;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    	int choice = 0;
    	UserDAO userDAO = (UserDAO)ac.getBean("userDAO");
        Scanner s = new Scanner(System.in);
    	System.out.println( "1. Register" );
        System.out.println("2. Login");
        System.out.println("Enter the Choice");
        choice = s.nextInt();
        UserDTO userDTO = (UserDTO)ac.getBean("userDTO");
        if(choice == 1) {
        	System.out.println("Enter the Userid");
        	userDTO.setUserid(s.next());
        	System.out.println("Enter the Password");
        	userDTO.setPassword(s.next());
        	System.out.println("Enter the Name");
        	userDTO.setName(s.next());
        	System.out.println("Enter the City");
        	userDTO.setCity(s.next());
        	if(userDAO.register(userDTO)) {
        		System.out.println("Register SuccessFully");
        	}
        	else {
        		System.out.println("Unable to Register");
        	}
        }
        else
        if(choice ==2) {	
        	System.out.println("Enter the Userid");
        	userDTO.setUserid(s.next());
        	System.out.println("Enter the Password");
        	userDTO.setPassword(s.next());
        	UserDTO user = userDAO.login(userDTO);
        	if(user!=null) {
        		System.out.println(user.getName()+" "+user.getCity());
        	}
        	else {
        		System.out.println("Not Found");
        	}
        }
        s.close();
        
    }
}
