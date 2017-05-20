package com.ikk.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikk.demo.Exception.DeviceCannotFindException;
import com.ikk.demo.model.DeviceEntity;
import com.ikk.demo.model.UserEntity;

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

	public DeviceEntity getDeviceById(Integer id) throws DeviceCannotFindException {
		Query query = manager.createQuery("Select d From DeviceEntity d where id = :id");
		query.setParameter("id", id);
		List<DeviceEntity> devices = query.getResultList();
		if(devices.size() == 1)
			return devices.get(0);
		else
			throw new DeviceCannotFindException();
	}
}
