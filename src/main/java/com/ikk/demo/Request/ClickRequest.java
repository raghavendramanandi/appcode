package com.ikk.demo.Request;

import java.io.Serializable;

public class ClickRequest implements Serializable{
	private String code;
	
	public ClickRequest(String code) {
		this.code = code;
	}
	
	public ClickRequest() {
	
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
