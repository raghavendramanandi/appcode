package com.ikk.demo.response;

import java.io.Serializable;

public class SuccessResponseTypeA extends SuccessResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String connName;
	private String password;
	
	
	public SuccessResponseTypeA(String code, String message, String data, String connName, String password) {
		super(code, message, data);
		this.connName = connName;
		this.password = password;
	}
	
	public String getConnName() {
		return connName;
	}
	public void setConnName(String connName) {
		this.connName = connName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		super.toString();
		return "SuccessResponseTypeA [connName=" + connName + ", password=" + password + "]";
	}
	
}
