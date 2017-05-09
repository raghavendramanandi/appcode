package com.ikk.demo.Util;

public class Util {

	public static String GetString(boolean[] encryptedValue) {
		StringBuilder sb = new StringBuilder("");
		for (boolean b : encryptedValue) {
			if(b)
				sb = sb.append("1");
			else
				sb = sb.append("0");
		}
		return sb.toString();
	}
}
