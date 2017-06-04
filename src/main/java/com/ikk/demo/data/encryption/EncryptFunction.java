package com.ikk.demo.data.encryption;

public class EncryptFunction implements IEncryprFunction{

	public boolean[] encrypt(boolean[] message) {
		int sizeOfSnippet = 4; 
		return doEncryption(message, sizeOfSnippet);
	}

	private boolean[] doEncryption(boolean[] message, int sizeOfSnippet) {
		System.out.println("Input: ");
		display(message);
		boolean[] encryptedMessage = new boolean[message.length];
		int size = message.length;
		int offset =0;
		for (int i = 0; i < sizeOfSnippet; i++) {
			offset = offset + (2^i);
		}
		offset += 50;
		boolean mask = false;//,true,false,false};
		for (int i = 0; i < message.length; i++) {
			System.out.println("iteration: " + i);
			System.out.println("in: "+ (message[i] ? '1' : '0'));
			System.out.println("offset: "+ offset);
			System.out.println("in: "+ ((offset + i) % size ) + "=" + (message[(offset + i) % size ] ? '1' : '0'));
			encryptedMessage[i] = message[i] & mask | message[i] ^ !mask ^ !(message[(offset + i) % size ]) ; 
			System.out.println("Output: "+encryptedMessage[i]);
		}
		System.out.println(encryptedMessage);
		System.out.println("Output: ");
		display(encryptedMessage);
		return encryptedMessage;
	}

	private void display(boolean[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]?'1':'0');
		}
		System.out.println();
	}
}
