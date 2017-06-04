package com.ikk.demo.response;

import java.io.Serializable;

public class SuccessResponseTypeB extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private String connName;
	private String code;
	private String data;
	private String password;

	public SuccessResponseTypeB(String code, String data, String connName, String password) {
		super();
		this.connName = connName;
		this.setPassword(password);
	}
	
	public String getConnName() {
		return connName;
	}
	public void setConnName(String connName) {
		this.connName = connName;
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

	@Override
	public String toString() {
		return "SuccessResponseTypeB [connName=" + connName + ", code=" + code + ", data="
				+ data + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}