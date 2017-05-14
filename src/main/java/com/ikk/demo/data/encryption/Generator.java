package com.ikk.demo.data.encryption;

import org.springframework.stereotype.Service;

@Service
public class Generator {
	public boolean [] getRandomNumber(int size) {
		boolean arr[] = new boolean[size];
		for (int i = 0; i < arr.length; i++) {
			int randomNumber = (int) (Math.random()*10 %2);
			if(randomNumber==1)
				arr[i]=true;
			else
				arr[i] =false;
		}
		return arr;
	}
}
