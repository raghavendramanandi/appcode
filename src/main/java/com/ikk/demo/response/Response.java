package com.ikk.demo.response;

public class Response {
	private String data;

	public String getCode() {
		return data;
	}

	public void setCode(String code) {
		this.data = code;
	}

	public Response(String code) {
		super();
		this.data = code;
	}

	@Override
	public String toString() {
		return "Response [code=" + data + "]";
	}
}
