package com.brainmentors.apps.jdbcexample;

class MyStack<T>{
	T arr [] ;
	int top;
	MyStack(T arr[]){
		this.arr = arr;
		top = -1;
	}
	void push(T data) {
		arr[top] = data;
		top++;
	}
	public T peek() {
		return arr[top];
	}
	
}
public class TemplateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String e [] = new String[10];
		MyStack<String> stack = new MyStack<>(e);
		Integer t [] = new Integer[10];
		MyStack<Integer> stack2 = new MyStack<>(t);

	}

}
