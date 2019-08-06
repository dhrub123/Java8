package com.dhruba.base64;

import java.util.Base64;

public class MIME {
	
	public static void main(String[] args) {
		
		//get encoder and decoder
		Base64.Encoder encoder = Base64.getMimeEncoder();
		Base64.Decoder decoder = Base64.getMimeDecoder();
		
		//Encoding Mime
		String encodedMime = encoder.encodeToString("Hello, \nYou are inefficient".getBytes());
		System.out.println("Encoded Mime = " + encodedMime);
		//Decoding Mime
		System.out.println("Decoded Mime = " + new String(decoder.decode(encodedMime))
				);
	}
}
