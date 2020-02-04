package sortdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//class SortByBalanceAsc implements Comparator<Customer>{
//
//	@Override
//	public int compare(Customer o1, Customer o2) {
//		// TODO Auto-generated method stub
//		return ((Double)o1.getBalance()).compareTo(o2.getBalance());
//	}
//	
//}
//class SortByBalanceDesc implements Comparator<Customer>{
//
//	@Override
//	public int compare(Customer o1, Customer o2) {
//		// TODO Auto-generated method stub
//		return ((Double)o2.getBalance()).compareTo(o1.getBalance());
//	}
//	
//}
class Customer implements Comparable<Customer>{
	private int id ;
	private String name;
	private double balance;
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Good Bye.. "+this);
	}
	@Override
	public int compareTo(Customer customer)
	{
		//return ((Double)this.balance).compareTo(customer.balance);
		//return this.name.compareTo(customer.name);
		return this.name.compareToIgnoreCase(customer.name);
	}
	Customer(int id, String name, double balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
		System.out.println("Cons Call");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Id "+id+" Name "+name+" Balance is "+balance+"\n";
	}
	
}
public class Demo1 {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1001, "Ram",1119999));
		customers.add(new Customer(1002, "Shyam",29999));
		customers.add(new Customer(1004, "anil",59999));
		customers.add(new Customer(1002, "ajay",99999));
		//Collections.sort(customers);
		//Collections.sort(customers, new SortByBalanceAsc());
		//Collections.sort(customers, new SortByBalanceDesc());
//		Collections.sort(customers
//				,(o1, o2)->o1.getName()
//				.compareTo(o2.getName()));
		Collections.sort(customers,(o1, o2)->
		((Double)o1.getBalance()).compareTo(o2.getBalance()));
		System.out.println(customers);
		
//		ArrayList<String> l= new ArrayList<>();
//		l.add("ram");
//		l.add("anil");
//		l.add("shyam");
//		System.out.println(l);
//		Collections.sort(l);
//		System.out.println(l);

	}

}
