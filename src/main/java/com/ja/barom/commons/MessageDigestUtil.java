package com.ja.barom.commons;

import java.security.MessageDigest;

public class MessageDigestUtil {

	public static String getPasswordHashCode(String password) {
		
		password = password + "!@Barom@!";
		
		String hashcode = null;
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update(password.getBytes("UTF-8"));
			byte [] chars = messageDigest.digest();
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < chars.length; i++) {
				String  temp = Integer.toHexString(chars[i] & 0xff);
				
				if(temp.length() == 1) {
					sb.append("0");
				}
				
				sb.append(temp);
				
				hashcode = sb.toString();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return hashcode;
	}
}
