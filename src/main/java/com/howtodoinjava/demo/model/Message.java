package com.howtodoinjava.demo.model;

public class Message {
	public String name;
	public String email;
	public String phone;
	public String message;
	
	@Override
	public String toString() {
		return "Message [name=" + name + ", email=" + email + ", phone=" + phone + ", message=" + message + "]";
	}
}
