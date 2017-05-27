package com.ikk.demo.response;

import java.io.Serializable;

public class ErrorResponse extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;

	public ErrorResponse(String code ) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ErrorResponse " + " code=" + code + "]";
	}
	
	
	
}
