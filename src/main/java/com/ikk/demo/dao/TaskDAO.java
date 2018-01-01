package com.ikk.demo.dao;

import java.util.List;

import com.ikk.demo.model.TaskEntity;

public interface TaskDAO {
	public List<TaskEntity> getAllTasks();
	public void addTast(TaskEntity task);
}