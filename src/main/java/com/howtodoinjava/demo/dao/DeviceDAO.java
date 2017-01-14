package com.howtodoinjava.demo.dao;

import java.util.List;

import com.howtodoinjava.demo.model.DepartmentEntity;
import com.howtodoinjava.demo.model.DeviceEntity;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.model.UserEntity;

public interface DeviceDAO {
	public List<DeviceEntity> getAllDevices();
	public List<UserEntity> getAllUsers();
	public void addDevice(DeviceEntity device);
}
