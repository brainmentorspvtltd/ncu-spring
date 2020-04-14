package com.brainmentors.testengine.models.user;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String userid;
	private String password;
	private String name;
	private String address;
	private  String phone;
	private String url;
	private String email;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", address=" + address + ", phone=" + phone + ", url="
				+ url + ", email=" + email + "]";
	}
	
}
