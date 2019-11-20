package com.encryp.builder.symmetry;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.encryp.utils.Utils;

public class CreateAESKeyHandler {
	/**
	 * 按指定字符串生成AES公钥
	 */
	public String createKey(String creatString){
		try {
			String str = creatString!=null?creatString:Utils.getRandomString(16,64);
			//1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keygen=KeyGenerator.getInstance("AES");
			//2.根据ecnodeRules规则初始化密钥生成器
			//生成一个128位的随机源,根据传入的字节数组
			
			keygen.init(128, new SecureRandom(str.getBytes()));
			//3.产生原始对称密钥
			SecretKey original_key=keygen.generateKey();
			//4.获得原始对称密钥的字节数组
			byte [] raw=original_key.getEncoded();
			return Utils.toHexString(raw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
