package com.ikk.demo.service;

import java.util.List;

import com.ikk.demo.model.Message;

public interface MessagesService {
	public List<Message> getMessages();
	public List<Message> getMessageForPhoneNumber(String phone);
	public void addMessage(Message message);
}
