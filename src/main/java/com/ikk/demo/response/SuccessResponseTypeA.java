package com.ikk.demo.response;

import java.io.Serializable;

public class SuccessResponseTypeA extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private String connName;
	private String password;
	private String code;
	private String message;
	private String data;
	
	public SuccessResponseTypeA(String code, String message, String data, String connName, String password) {
		super();
		this.data = data;
		this.code = code;
		this.message = message;
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
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SuccessResponseTypeA [connName=" + connName + ", password=" + password + ", code=" + code + ", message="
				+ message + ", data=" + data + "]";
	}
	
}
