package com.ikk.demo.response;

import java.io.Serializable;

public class SuccessResponseTypeB extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private String connName;
	private String code;
	private String message;
	private String data;

	public SuccessResponseTypeB(String code, String message, String data, String connName) {
		super();
		this.connName = connName;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SuccessResponseTypeB [connName=" + connName + ", code=" + code + ", message=" + message + ", data="
				+ data + "]";
	}
}