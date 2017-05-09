package com.ikk.demo.response;

import java.io.Serializable;

public class ErrorResponse extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private String code;

	public ErrorResponse(String message, String code, String data ) {
		super(data);
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", code=" + code + "]";
	}
	
	
	
}
