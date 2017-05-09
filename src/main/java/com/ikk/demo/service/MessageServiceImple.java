package com.ikk.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikk.demo.dao.MessageDAO;
import com.ikk.demo.model.Message;

@Service
public class MessageServiceImple implements MessagesService{
	@Autowired
	MessageDAO mDao;
	
	public List<Message> getMessages() {
		return mDao.getAllMessages();
	}
	
	public List<Message> getMessageForPhoneNumber(String phone) {
		return mDao.getMessageByPhone(phone);
	}
	
	public void addMessage(Message message) {
		mDao.addMessage(message);
	}
}
