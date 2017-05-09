package com.ikk.demo.response;

import java.io.Serializable;

public class SuccessResponseTypeB extends SuccessResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String connName;

	public SuccessResponseTypeB(String code, String message, String data, String connName) {
		super(code, message, data);
		this.connName = connName;
	}
	
	public String getConnName() {
		return connName;
	}
	public void setConnName(String connName) {
		this.connName = connName;
	}

	@Override
	public String toString() {
		super.toString();
		return "SuccessResponseTypeA [connName=" + connName + "]";
	}
	
}