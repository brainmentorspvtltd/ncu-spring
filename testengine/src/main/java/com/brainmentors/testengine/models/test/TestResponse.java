package com.brainmentors.testengine.models.test;

public class TestResponse {
	private String name;
	private String message;
	private String statusCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "TestResponse [name=" + name + ", message=" + message + ", statusCode=" + statusCode + "]";
	}
	

}
