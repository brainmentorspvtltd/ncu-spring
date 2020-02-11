package com.brainmentors.apps.annotationdemo;

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
       X x = (X)ac.getBean("x");
       x.getObj().emi();
       A a = (A) ac.getBean("a");
       System.out.println(a.getId());
       //a.fillX(90);
       //a.getB().show();
    }
}
