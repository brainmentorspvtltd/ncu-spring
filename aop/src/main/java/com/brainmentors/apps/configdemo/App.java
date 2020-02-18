package com.brainmentors.apps.configdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	
    	// AOP
    	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    	X x =(X)ac.getBean("x");
    	x.logic();
    	Y y =(Y)ac.getBean("y");
    	y.logical();
//    	System.setOut(new PrintStream(new File("/Users/amit/Documents/logs/result.log")));
//    	ApplicationContext ac = 
//    			new AnnotationConfigApplicationContext(ConfigBeans.class);
//    	A a = (A)ac.getBean("a");
//    	IB b = a.getObj();
//    	b.print();
    	//a.getObj().print();
    	//Math math = new Math();
        //System.out.println( "Hello World!" );
    }
}
