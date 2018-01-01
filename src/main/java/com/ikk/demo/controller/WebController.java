package com.ikk.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikk.demo.model.Message;
import com.ikk.demo.service.ClickService;
import com.ikk.demo.service.MessagesService;

@RestController
@RequestMapping("/web")
public class WebController
{

	@Autowired
	MessagesService ms;
	@Autowired
	ClickService cs;
	ObjectMapper mapper = new ObjectMapper();
	
	public WebController() {
		this.mapper = new ObjectMapper();
	}
	
	
	@RequestMapping(value = "/message", headers="Accept=*/*",  produces="application/json", method = RequestMethod.POST)
	public void submitMessage( @RequestBody Message message){
		System.out.println(message.toString());
		ms.addMessage(message);
	}
}