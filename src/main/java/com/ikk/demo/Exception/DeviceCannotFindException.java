package com.ikk.demo.Exception;

public class DeviceCannotFindException extends Exception {
	@Override
	public String getMessage(){
		return "Either there are no device or there are more than one device";
	}
}
