package com.encryp.handler.other;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.encryp.utils.Utils;
import com.encryp.utils.annotations.CPStringEncrypFalg;

public class SHAHandler {
	/**
	 * SHA没有解密算法
	 * @param passWord 需要加密的密码
	 * @return 加密后密码
	 */
	@CPStringEncrypFalg(2)
	public String SHA(String userName,String passWord){
		MessageDigest sha;
		try {
			sha = MessageDigest.getInstance("SHA");
			sha.update(passWord.getBytes(Utils.EncrypCode));
			byte[] bytes = sha.digest();
			return Utils.toHexString(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] SHA(String userName,byte[] passWord){
		MessageDigest sha;
		try {
			sha = MessageDigest.getInstance("SHA");
			sha.update(passWord);
			return sha.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
