package com.ikk.demo.data.encryption;

public class EncryptFunction implements IEncryprFunction{

	public void encrypt(boolean[] message) {
		//fixed size intervals = start with 3 bits
		//mod n of functions will define which function to call
		//
		
		int sizeOfSnippet = 4; // size of snippet should give perfect devisible number
		makeSnippets(message, sizeOfSnippet);
		//printSubText(subArray);
	}
	
	private void makeSnippets(boolean[] message, int sizeOfSnippet) {
		int numberOfDenomination = message.length / sizeOfSnippet;
		Boolean [] subArray;
		for(int i =0;i< numberOfDenomination ;i++){
			subArray = new Boolean[sizeOfSnippet];
			for(int j =0;j<sizeOfSnippet;j++){
				subArray[j] = message[(i*sizeOfSnippet)+j];
				//System.out.print((i*sizeOfSnippet)+j + " ,");
			}
			System.out.println();
			printSubText(subArray);
		}
	}

	private Boolean [] printSubText(Boolean [] snippet) {
		for (Boolean boolean1 : snippet) {
			System.out.print(boolean1);
		}
		System.out.println();
		return snippet;
	}

}
