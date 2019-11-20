package com.encryp.handler.other;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.encryp.utils.Utils;
import com.encryp.utils.annotations.CPStringEncrypFalg;

public class MD5Handler {
	/**
	 * MD5没有解密算法
	 * @param passWord 需要加密的密码
	 * @return MD5加密后密码
	 */
	@CPStringEncrypFalg(0)
	public String MD5(String userName,String passWord){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md.digest(passWord.getBytes(Utils.EncrypCode));
			return Utils.toHexString(md5Bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] MD5(String userName,byte[] passWord){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return md.digest(passWord);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
