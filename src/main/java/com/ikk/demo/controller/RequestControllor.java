package com.ikk.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikk.demo.response.Response;
import com.ikk.demo.service.ClickService;
import com.ikk.demo.service.MessagesService;

@RestController
@RequestMapping("/button")
public class RequestControllor
{
	@Autowired
	MessagesService ms;
	@Autowired
	ClickService cs;
	ObjectMapper mapper = new ObjectMapper();
	
	public RequestControllor() {
		this.mapper = new ObjectMapper();
	}
	
	@RequestMapping(value = "/Ganapa")
	public String Ganapa() {
		//return new GResponse("Ganapa").getResponse();
		return "Ganapa";
	}
	
	@RequestMapping(value = "/click/{id}",
			method = RequestMethod.POST)
	public Response OnClick(@PathVariable("id") int id){
			return cs.ClickAction(id);
	}
}