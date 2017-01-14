package com.ikk.response;

import java.io.Serializable;

public class SuccessResponse extends Response implements Serializable{
	private String code;
	private String message;
	
	
	public SuccessResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SuccessResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
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
		return "SuccessResponse [code=" + code + ", message=" + message + "]";
	}
	
	
	
	
}
