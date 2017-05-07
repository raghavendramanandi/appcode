package com.ikk.demo.dao;

import java.util.List;

import com.ikk.demo.model.DepartmentEntity;
import com.ikk.demo.model.EmployeeEntity;

public interface EmployeeDAO 
{
	public List<EmployeeEntity> getAllEmployees();
	public List<DepartmentEntity> getAllDepartments();
	public void addEmployee(EmployeeEntity employee);
}