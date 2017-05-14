package com.ikk.demo.data.encryption;

public class EncryptFunction implements IEncryprFunction{

	public boolean[] encrypt(boolean[] message) {
		int sizeOfSnippet = 4; 
		return doEncryption(message, sizeOfSnippet);
	}

	private boolean[] doEncryption(boolean[] message, int sizeOfSnippet) {
		boolean[] encryptedMessage = new boolean[message.length];
		int size = message.length;
		int offset =0;
		for (int i = 0; i < sizeOfSnippet; i++) {
			offset = offset + (2^i);
		}
		offset += 50;
		boolean mask = false;//,true,false,false};
		for (int i = 0; i < message.length; i+=sizeOfSnippet) {
			encryptedMessage[i] = message[i] & mask | message[i] ^ !mask ^ !(message[(offset + i) % size ]) ; 
		}
		System.out.println(encryptedMessage);
		return encryptedMessage;
	}
}
