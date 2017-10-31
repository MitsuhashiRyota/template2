package com.internousdev.komozon.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CreateTokenUtil {

	private static int TOKEN_LENGTH = 16;

	public static String createToken() {
		byte token[] = new byte[TOKEN_LENGTH];
		StringBuffer buffer = new StringBuffer();
		SecureRandom secureRandom;
		String userToken = "";

		try {
			secureRandom = SecureRandom.getInstanceStrong();
			secureRandom.nextBytes(token);

			for(int i=0; i < token.length; i++) {
				buffer.append(String.format("%02x", token[1]));
			}

			userToken = buffer.toString();

		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return userToken;
	}
}
