package com.howtodoinjava.demo.controller;

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

import com.howtodoinjava.demo.editors.DepartmentEditor;
import com.howtodoinjava.demo.model.DepartmentEntity;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.model.GResponse;
import com.howtodoinjava.demo.model.Message;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.ikk.response.Response;
import com.ikk.response.SuccessResponse;

@RestController
@RequestMapping("/ikk")
public class RequestControllor
{

	public RequestControllor() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/Ganapa")
	public String Ganapa() {
		//return new GResponse("Ganapa").getResponse();
		return "Ganapa";
	}
	
	@RequestMapping(value = "/success", headers="Accept=*/*",  produces="application/json")
	public Response getSuccessMessage(){
		return new SuccessResponse("200", "Success");
	}
	
	@RequestMapping(value = "/message", headers="Accept=*/*",  produces="application/json", method = RequestMethod.POST)
	public void getMessage( @RequestBody Message message){
		System.out.println(message.toString());
	}
}