package com.brainmentors.hibernatedemo.hibernatedemoapp;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public String findById(int id)
	{	
		Session session = sf.openSession();
		try {
		
		Employee emp = session.get(Employee.class, id);
		if(emp!=null) {
			return "Employee Found "+emp.getName()+" "+emp.getSalary();
		}
		else {
			return "Employee Not Found";
		}
		}
		finally {
			session.close();
		}
	}
	
	
	public String removeById(int id) {
		String msg = "";
		Session session = sf.openSession();
		
		
		Employee emp = session.get(Employee.class, id);
		if(emp!=null) {
			Transaction trans = session.beginTransaction();
			session.delete(emp);
			trans.commit();
			msg = "Record Deleted";
		}
		else {
			msg = "Record Not Found So Can't Delete";
		}
		session.close();
		return  msg;
	}
	
	public String updateById(int id) {
		String msg = "";
		Session session = sf.openSession();
		
		
		Employee emp = session.get(Employee.class, id);
		if(emp!=null) {
			Transaction trans = session.beginTransaction();
			emp.setSalary(emp.getSalary()+10000);
			session.update(emp);
			trans.commit();
			msg = "Record Updated";
		}
		else {
			msg = "Record Not Found So Can't Update";
		}
		session.close();
		return  msg;
	}
	
	public String addEmployee(Employee emp) {
		// Transient
		emp.setSalary(emp.getSalary()+ 100);
		Session session = sf.openSession();
		// Persist
		Transaction trans = session.beginTransaction();
		session.save(emp); 
		//emp.setSalary(emp.getSalary() + 200);
		trans.commit();
		
		session.close();
		// DeAttach
		return "Record Added";
		}
	
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 3);
		c.set(Calendar.DAY_OF_MONTH, 21);
		c.set(Calendar.YEAR, 2020);
		//String result = dao.findById(2);
		//System.out.println(result);
		String result = dao.updateById(4);
		System.out.println(result);
		
		//Employee emp = new Employee("Tim",9999,c.getTime());
		//String msg  =dao.addEmployee(emp);
		//System.out.println(msg);
	}
}
