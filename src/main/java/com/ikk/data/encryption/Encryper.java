package com.ikk.data.encryption;

public class Encryper {

	public boolean[] getEncryptedValue(boolean[] arr) {
		IEncryprFunction encryptFunction = new EncryptFunction();
		encryptFunction.encrypt(arr);
		return null;
	}
}
