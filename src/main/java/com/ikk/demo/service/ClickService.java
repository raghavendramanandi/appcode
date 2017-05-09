package com.ikk.demo.service;

import com.ikk.demo.Exception.DeviceCannotFindException;
import com.ikk.demo.Exception.InvalidModeException;
import com.ikk.demo.response.Response;

public interface ClickService {
	public Response ClickAction(Integer id);
}
