package com.howtodoinjava.demo.dao;

import java.util.List;

import com.howtodoinjava.demo.model.Message;

public interface MessageDAO {
	public List<Message> getAllMessages();
	public Message getMessageById(Integer id) ;
	public List<Message> getMessageByPhone(String phone);
	public void addMessage(Message message);
}
