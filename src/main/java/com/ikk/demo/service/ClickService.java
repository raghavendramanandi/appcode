package com.ikk.demo.service;

import com.ikk.demo.Request.ClickRequest;
import com.ikk.demo.response.Response;

public interface ClickService {
	public Response ClickAction(Integer id, ClickRequest postData);
}
