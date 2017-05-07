package com.ikk.demo.dao;

import java.util.List;

import com.ikk.demo.model.Message;

public interface MessageDAO {
	public List<Message> getAllMessages();
	public Message getMessageById(Integer id) ;
	public List<Message> getMessageByPhone(String phone);
	public void addMessage(Message message);
}
