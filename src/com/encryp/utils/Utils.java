package com.encryp.utils;

import java.util.Random;

public class Utils {
	public static final String EncrypCode = "UTF-8";
	/**
	 * 
	 * @param byteArray  byte数组
	 * @return 16进制字符串
	 */
	public static String toHexString(byte[] byteArray) {
		if (byteArray == null || byteArray.length < 1)
			throw new IllegalArgumentException("this byteArray must not be null or empty");

		final StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
				hexString.append("0");
			hexString.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return hexString.toString().toLowerCase();
	}

	/**
	 * 
	 * @param hexString 16进制字符串
	 * @return byte数组
	 */
	public static byte[] toByteArray(String hexString) {
		if (hexString == null ||hexString.length()==0)
			throw new IllegalArgumentException("this hexString must not be empty");

		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}
	
	
	/**
	 * 产生指定长度的随机字符串
	 */
	 public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	 /**
	  * 产生指定长度内的随机长度随机字符串
	  */
	 public static String getRandomString(int min,int max){
		 Random random=new Random();
		 return Utils.getRandomString(random.nextInt(max-min)+min);
	 }
}