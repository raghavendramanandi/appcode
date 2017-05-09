package com.ikk.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikk.demo.model.DepartmentEntity;
import com.ikk.demo.model.DeviceEntity;
import com.ikk.demo.model.EmployeeEntity;
import com.ikk.demo.model.TaskEntity;
import com.ikk.demo.model.UserEntity;

@Repository
@Transactional
public class TaskDAOImpl implements TaskDAO{

	@PersistenceContext
	private EntityManager manager;

	public List<TaskEntity> getAllTasks() {
		List<TaskEntity> tasks = manager.createQuery("Select t From TaskEntity d", TaskEntity.class).getResultList();
        return tasks;
	}

	public void addTast(TaskEntity task) {
		manager.persist(task);
	}
	
}
