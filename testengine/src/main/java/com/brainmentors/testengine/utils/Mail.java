package com.brainmentors.testengine.utils;

import com.brainmentors.testengine.models.user.UserInfo;

public class Mail {
	
	public boolean sendMail(UserInfo userInfo) {
		return true;
	}
	static int power(int base, int p) {
		if(p==0) {
			return 1;
		}
		return base * power(base,p-1);
	}
	static void print(int n){
		if(n<=0) {
			return ;
		}
		if(n%2!=0) {
		System.out.println(n);
		}
		print(n-1);
		if(n%2==0) {
		System.out.println(n);
		}
		
	}
	public static void main(String[] args) {
		//print(5);
		System.out.println(power(2,3));
	}

}
