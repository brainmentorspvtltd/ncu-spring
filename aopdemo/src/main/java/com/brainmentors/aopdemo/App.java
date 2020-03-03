package com.brainmentors.aopdemo;

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
       A a = (A)ac.getBean("a");
       a.print();
       System.out.println("************************************");
       B b = (B)ac.getBean("b");
       b.print2();
    }
}
