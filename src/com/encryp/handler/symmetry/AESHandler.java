package com.encryp.handler.symmetry;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.encryp.utils.Utils;

public class AESHandler {
	/**
	 * AES加密
	 */
	public String Encrypt(String publicKey,String passWord){
		try {
			//1.根据字节数组生成AES密钥
			SecretKey key=new SecretKeySpec(Utils.toByteArray(publicKey), "AES");
			//2.根据指定算法AES自成密码器
			Cipher cipher=Cipher.getInstance("AES");
			//3.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//4.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
			byte [] byte_encode=passWord.getBytes(Utils.EncrypCode);
			//5.根据密码器的初始化方式--加密：将数据加密
			byte [] byte_AES=cipher.doFinal(byte_encode);
			//6.将加密后的数据转换为字符串
			String AES_encode=Utils.toHexString(byte_AES);
			//7.将字符串返回
			return AES_encode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] Encrypt(String publicKey,byte[] data){
		try {
			//1.根据字节数组生成AES密钥
			SecretKey key=new SecretKeySpec(Utils.toByteArray(publicKey), "AES");
			//2.根据指定算法AES自成密码器
			Cipher cipher=Cipher.getInstance("AES");
			//3.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//4.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
			byte [] byte_encode=data;
			//5.根据密码器的初始化方式--加密：将数据加密
			byte [] byte_AES=cipher.doFinal(byte_encode);
			return byte_AES;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * AES解密
	 */
	public String Decrypt(String publicKey,String passWord){
		try {
			//1.根据字节数组生成AES密钥
			SecretKey key=new SecretKeySpec(Utils.toByteArray(publicKey), "AES");
			//2.根据指定算法AES自成密码器
			Cipher cipher=Cipher.getInstance("AES");
			//3.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.DECRYPT_MODE, key);
			//4.将加密并编码后的内容解码成字节数组
			byte [] byte_content= Utils.toByteArray(passWord);
			/*
			 * 解密
			 */
			byte [] byte_decode=cipher.doFinal(byte_content);
			String AES_decode=new String(byte_decode,Utils.EncrypCode);
			return AES_decode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] Decrypt(String publicKey,byte[] data){
		try {
			//1.根据字节数组生成AES密钥
			SecretKey key=new SecretKeySpec(Utils.toByteArray(publicKey), "AES");
			//2.根据指定算法AES自成密码器
			Cipher cipher=Cipher.getInstance("AES");
			//3.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.DECRYPT_MODE, key);
			/*
			 * 解密并返回
			 */
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
