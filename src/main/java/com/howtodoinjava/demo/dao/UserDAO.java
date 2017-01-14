package com.howtodoinjava.demo.dao;

import java.util.List;

import com.howtodoinjava.demo.model.UserEntity;

public interface UserDAO {
	public List<UserEntity> getAllUsers();
	public void addDevice(UserEntity user) ;
}
