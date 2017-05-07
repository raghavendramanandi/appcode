package com.ikk.demo.dao;

import java.util.List;

import com.ikk.demo.model.DepartmentEntity;
import com.ikk.demo.model.DeviceEntity;
import com.ikk.demo.model.EmployeeEntity;
import com.ikk.demo.model.UserEntity;

public interface DeviceDAO {
	public List<DeviceEntity> getAllDevices();
	public List<UserEntity> getAllUsers();
	public void addDevice(DeviceEntity device);
}
