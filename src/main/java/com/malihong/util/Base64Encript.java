package com.malihong.util;

import org.apache.tomcat.util.codec.binary.Base64;

public class Base64Encript {

	public static String encode(String str) {
		byte[] encodedBytes = Base64.encodeBase64(str.getBytes());
		return new String(encodedBytes);
	}
	
	public static String decode(String str) {
		byte[] decodedBytes = Base64.decodeBase64(str);
		return new String(decodedBytes);
	}
	
	//Test method
	public static void main(String[] args) {
		String encode = Base64Encript.encode("Shuhao");
		System.out.println("Encode: " + encode);
		System.out.println("Decode: " +  Base64Encript.decode(encode));
	}
}
