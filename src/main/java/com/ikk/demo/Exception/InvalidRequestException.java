package com.ikk.demo.Exception;

import java.io.Serializable;

public class InvalidRequestException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Device failes authorization";
	}
}
