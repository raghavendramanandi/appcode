package com.howtodoinjava.demo.service;

import java.util.List;

import com.howtodoinjava.demo.model.Message;

public interface MessagesService {
	public List<Message> getMessages();
	public List<Message> getMessageForPhoneNumber(String phone);
	public void addMessage(Message message);
}
