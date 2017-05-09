package com.ikk.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikk.demo.model.DeviceEntity;
import com.ikk.demo.model.UserEntity;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = manager.createQuery("Select u From UserEntity u", UserEntity.class).getResultList();
        return users;
	}

	public void addDevice(UserEntity user) {
		manager.persist(user);
	}
}
