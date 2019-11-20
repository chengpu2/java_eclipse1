package com.encryp.handler.other;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.encryp.utils.Utils;

public class HMACHandler {
	/**
	 * HMAC加密
	 */
	public String HMAC(String str,String key) {
		// 用于存储加密后的16进制字符串
        String cipher = "";
        try {
            byte[] data = key.getBytes();
            // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
            // 生成HmacSHA256专属密钥
            SecretKey secretKey = new SecretKeySpec(data, "HmacSHA256");
            // 生成一个指定 Mac 算法 的 Mac 对象
            Mac mac = Mac.getInstance("HmacSHA256");
            // 用给定密钥初始化 Mac 对象
            mac.init(secretKey);
            byte[] text = str.getBytes(Utils.EncrypCode);
            // 完成 Mac 操作
            byte[] encryptByte = mac.doFinal(text);
            // 将byte[]-->hexString
            cipher = Utils.toHexString(encryptByte);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("HMACSHA256加密失败：" + e.getMessage());
        }
        return cipher;
	}
	public byte[] HMAC(byte[] str,String key) {
		// 用于存储加密后的16进制字符串
        byte[] cipher = null;
        try {
            byte[] data = key.getBytes();
            // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
            // 生成HmacSHA256专属密钥
            SecretKey secretKey = new SecretKeySpec(data, "HmacSHA256");
            // 生成一个指定 Mac 算法 的 Mac 对象
            Mac mac = Mac.getInstance("HmacSHA256");
            // 用给定密钥初始化 Mac 对象
            mac.init(secretKey);
            byte[] text = str;
            // 完成 Mac 操作
            byte[] encryptByte = mac.doFinal(text);
            // 将byte[]-->hexString
            cipher = encryptByte;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("HMACSHA256加密失败：" + e.getMessage());
        }
        return cipher;
	}
}
