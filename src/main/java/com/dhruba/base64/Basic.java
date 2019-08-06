package com.dhruba.base64;

import java.util.Base64;

public class Basic {
	
	public static void main(String[] args) {
		
		//get encoder and decoder
		Base64.Encoder encoder = Base64.getEncoder();
		Base64.Decoder decoder = Base64.getDecoder();
		//create a byte array
		byte[] byteArr = {1,2};
		//encode byte array
		byte[] byteArr2 = encoder.encode(byteArr);
		System.out.println("Encoded array = " + byteArr2);
		//decode encoded array
		byte[] decodeArray = decoder.decode(byteArr2);
		System.out.println(decodeArray[1]);
		
		//Encoding String
		String encodedString = encoder.encodeToString("Hello! This is Dhruba".getBytes());
		System.out.println("Encoded String = " + encodedString);
		//Decoding String
		System.out.println("Decoded String = " + new String(decoder.decode(encodedString))
				);
	}
}
