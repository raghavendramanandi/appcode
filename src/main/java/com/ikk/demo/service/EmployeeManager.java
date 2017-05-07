package com.ikk.demo.service;

import java.util.List;

import com.ikk.demo.model.DepartmentEntity;
import com.ikk.demo.model.EmployeeEntity;

public interface EmployeeManager 
{
	public List<EmployeeEntity> getAllEmployees();
	public List<DepartmentEntity> getAllDepartments();
	public void addEmployee(EmployeeEntity employee);
}
