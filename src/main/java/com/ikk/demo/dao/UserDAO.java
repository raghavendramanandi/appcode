package com.ikk.demo.dao;

import java.util.List;

import com.ikk.demo.model.UserEntity;

public interface UserDAO {
	public List<UserEntity> getAllUsers();
	public void addDevice(UserEntity user) ;
}
