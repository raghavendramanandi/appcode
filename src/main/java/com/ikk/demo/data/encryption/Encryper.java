package com.ikk.demo.data.encryption;

import org.springframework.stereotype.Service;

@Service
public class Encryper {

	public boolean[] getEncryptedValue(boolean[] arr) {
		IEncryprFunction encryptFunction = new EncryptFunction();
		return encryptFunction.encrypt(arr);
	}
}
