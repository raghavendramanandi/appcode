package com.howtodoinjava.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.demo.model.DepartmentEntity;
import com.howtodoinjava.demo.model.DeviceEntity;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.model.Message;
import com.howtodoinjava.demo.model.UserEntity;

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Message> getAllMessages() {
		List<Message> messages = manager.createQuery("Select d From message d", Message.class).getResultList();
        return messages;
	}


	public Message getMessageById(Integer id) 
	{
        return manager.find(Message.class, id);
	}
	
	public List<Message> getMessageByPhone(String phone){
		//return manager.find(Message.class, phone);
		Query query = manager.createNamedQuery("select * from message where phone = :phone");
		query.setParameter("phone", phone);
		 List<Message> messages = query.getResultList();
		 return messages;
	}
	
	public void addMessage(Message message) {
		//Use null checks and handle them
		manager.persist(message);
	}
}
