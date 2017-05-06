package com.howtodoinjava.demo.controller;

import java.io.Serializable;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.demo.editors.DepartmentEditor;
import com.howtodoinjava.demo.model.DepartmentEntity;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.model.GResponse;
import com.howtodoinjava.demo.model.Message;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.howtodoinjava.demo.service.MessagesService;
import com.ikk.response.ClickResponse;
import com.ikk.response.Response;
import com.ikk.response.SuccessResponse;
import com.ikk.response.SuccessfulClickResponse;

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

