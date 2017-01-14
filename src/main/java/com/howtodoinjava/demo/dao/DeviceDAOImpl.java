package com.howtodoinjava.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.demo.model.DepartmentEntity;
import com.howtodoinjava.demo.model.DeviceEntity;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.model.UserEntity;

@Repository
@Transactional
public class DeviceDAOImpl implements DeviceDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public List<DeviceEntity> getAllDevices() {
		List<DeviceEntity> devices = manager.createQuery("Select d From DeviceEntity d", DeviceEntity.class).getResultList();
        return devices;
	}

	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = manager.createQuery("Select u From UserEntity u", UserEntity.class).getResultList();
        return users;
	}

	public UserEntity getUserById(Integer id) 
	{
        return manager.find(UserEntity.class, id);
	}
	
	public void addDevice(DeviceEntity device) {
		//Use null checks and handle them
		device.setUser(getUserById(device.getUser().getId()));
		manager.persist(device);
	}
}
