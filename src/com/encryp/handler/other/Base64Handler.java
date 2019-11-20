package com.encryp.handler.other;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import com.encryp.utils.Utils;
import com.encryp.utils.annotations.CPStringEncrypFalg;

public class Base64Handler {
	/**
	 * 
	 * @param passWord 需要加密的密码
	 * @return Base64加密后密码
	 */
	@CPStringEncrypFalg(1)
	public String Base64(String userName,String passWord){
		byte[] array;
		try {
			array = Base64.encodeBase64(passWord.getBytes(Utils.EncrypCode));
			return new String(array);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] Base64(String userName,byte[] passWord){
		return Base64.encodeBase64(passWord);
	}
	
	/**
	 * 
	 * @param passWord 需要解密密码
	 * @return  解密后密码
	 */
	public String Base64Decrypt(String userName,String passWord){
		byte[] array1;
		try {
			array1 = Base64.decodeBase64(passWord.getBytes(Utils.EncrypCode));
			return new String(array1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] Base64Decrypt(String userName,byte[] passWord){
		return Base64.decodeBase64(passWord);
	}
}
