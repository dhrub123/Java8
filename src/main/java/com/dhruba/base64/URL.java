package com.dhruba.base64;

import java.util.Base64;

public class URL {
	
	public static void main(String[] args) {
		
		//get encoder and decoder
		Base64.Encoder encoder = Base64.getUrlEncoder();
		Base64.Decoder decoder = Base64.getUrlDecoder();
		
		//Encoding URL
		String encodedUrl = encoder.encodeToString("www.dhruba.com".getBytes());
		System.out.println("Encoded URL = " + encodedUrl);
		//Decoding URL
		System.out.println("Decoded URL = " + new String(decoder.decode(encodedUrl))
				);
	}
}
