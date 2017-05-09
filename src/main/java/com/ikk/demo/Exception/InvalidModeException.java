package com.ikk.demo.Exception;

import java.io.Serializable;

public class InvalidModeException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Operation mode on device is invalid";
	}
}