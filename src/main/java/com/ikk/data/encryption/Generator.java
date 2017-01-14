package com.ikk.data.encryption;

public class Generator {
	
	public boolean [] getRandomNumber(int size) {
		boolean arr[] = new boolean[size];
		for (int i = 0; i < arr.length; i++) {
			int randomNumber = (int) (Math.random()*10 %2);
			System.out.println("is: " + randomNumber);
			if(randomNumber==1)
				arr[i]=true;
			else
				arr[i] =false;
		}
		return arr;
	}
}
