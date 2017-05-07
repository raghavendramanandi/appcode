package com.ikk.demo.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikk.demo.model.Message;
import com.ikk.demo.response.Response;
import com.ikk.demo.response.SuccessResponse;
import com.ikk.demo.service.MessagesService;

@RestController
@RequestMapping("/ikk")
public class RequestControllor
{

	@Autowired
	MessagesService ms;
	ObjectMapper mapper = new ObjectMapper();
	
	public RequestControllor() {
		// TODO Auto-generated constructor stub
		this.mapper = new ObjectMapper();
	}
	
	@RequestMapping(value = "/Ganapa")
	public String Ganapa() {
		//return new GResponse("Ganapa").getResponse();
		return "Ganapa";
	}
	
	@RequestMapping(value = "/apple")
	public String Apple() {
		//return new GResponse("Ganapa").getResponse();
		return "{\"code\":\"200\",\"message\":\"Success\"}";
	}
	
	@RequestMapping(value = "/success", headers="Accept=*/*",  produces="application/json")
	public Response getSuccessMessage(){
		return new SuccessResponse("200", "Success");
	}
	
	@RequestMapping(value = "/message", headers="Accept=*/*",  produces="application/json", method = RequestMethod.POST)
	public void getMessage( @RequestBody Message message){
		System.out.println(message.toString());
		ms.addMessage(message);
	}
	
	@RequestMapping(value = "/click")
	public String Action(){
		try {
			SuccessResponse response = new SuccessResponse();
			System.out.println(response.toString());
			return mapper.writeValueAsString(response);
		} catch (Exception e) {
			e.printStackTrace();
			return "i a catch";
		}
		finally {
			System.out.println("I am finally");
		}
	}
	
	@RequestMapping(value = "/apple1")
	public String ActionForApple(){
		try {
			DummyResponse response = new DummyResponse();
			System.out.println(response.toString());
			return mapper.writeValueAsString(response);
		} catch (Exception e) {
			e.printStackTrace();
			return "i a catch";
		}
		finally {
			System.out.println("I am finally");
		}
	}
}

class DummyResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String mode = "1";
	private String code = "101001010101";
	private String status = "success";
	
	DummyResponse(){
		mode = "1";
		code = "101001010101";
		status = "success";
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DummyResponse [mode=" + mode + ", code=" + code + ", status=" + status + "]";
	}
	
	
}

