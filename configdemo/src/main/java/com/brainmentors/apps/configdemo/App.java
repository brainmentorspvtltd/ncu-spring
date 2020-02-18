package com.brainmentors.apps.configdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ac = 
    			new AnnotationConfigApplicationContext(ConfigBeans.class);
    	A a = (A)ac.getBean("a");
    	IB b = a.getObj();
    	b.print();
    	//a.getObj().print();
    	//Math math = new Math();
        //System.out.println( "Hello World!" );
    }
}
