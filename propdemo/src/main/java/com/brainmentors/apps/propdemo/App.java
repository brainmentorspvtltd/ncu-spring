package com.brainmentors.apps.propdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
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
       Employee emp = (Employee)ac.getBean("emp");
       emp.getMyBean();
       System.out.println(emp);
       ((ConfigurableApplicationContext)ac).close();
       
       
    }
}
