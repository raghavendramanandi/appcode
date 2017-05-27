package com.ikk.demo.response;

import java.io.Serializable;

public class SuccessResponse extends Response implements Serializable{

	private static final long serialVersionUID = 1L;
	private String code;
	private String data;

	
	public SuccessResponse(String code, String data) {
		this.data = data;
		this.code = code;
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
		return "SuccessResponse [code=" + code + "]";
	}
}
