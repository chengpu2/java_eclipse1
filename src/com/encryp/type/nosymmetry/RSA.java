package com.encryp.type.nosymmetry;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

import com.encryp.handler.onsymmetry.RSAHandler;
import com.encryp.pojo.NoSymmetryKey;
import com.encryp.utils.Utils;
public class RSA {
	private NoSymmetryKey key;
	private RSAHandler rsaHandler = null;
	private void getHandler(){
		if(rsaHandler == null){
			rsaHandler = new RSAHandler();
		}
	}
	/**
	 * 获取公钥，一般用于发送
	 */
	public NoSymmetryKey getKey() {
		//外界无法获取私钥,防止泄露
		return new NoSymmetryKey(null,key.getPublicKey());
	}
	/**
	 * 设置公钥，一般通过其他端获得,可能导致将原来key覆盖，不建议使用,请通过直接新建RSA来设置
	 */
	public void setKey(String key) {
		this.key.setPublicKey(key);
	}
	/**
	 * 设置公钥，一般通过其他端获得,可能导致将原来key覆盖，不建议使用,请通过直接新建RSA来设置
	 */
	public void setKey(NoSymmetryKey key) {
		this.key.setPublicKey(key.getPublicKey());
	}
	public RSA(NoSymmetryKey key){
		this.key = key;
	}
	public RSA(String publicKey){
		this.key = new NoSymmetryKey(publicKey);
	}
	
	/**
	 * 公钥加密
	 */
	public String publicEncrypt(String text){
		getHandler();
		try {
			RSAPublicKey publicKey = rsaHandler.getPublicKey(key.getPublicKey());
			return rsaHandler.publicEncrypt(text, publicKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 公钥加密
	 */
	public byte[] publicEncrypt(byte[] data){
		getHandler();
		try {
			RSAPublicKey publicKey = rsaHandler.getPublicKey(key.getPublicKey());
			return rsaHandler.publicEncrypt(data, publicKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 私钥解密
	 */
	public String privateDecrypt(String passWord){
		getHandler();
		try {
			RSAPrivateKey privateKey = rsaHandler.getPrivateKey(key.getPrivateKey());
			return rsaHandler.privateDecrypt(passWord, privateKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 私钥解密
	 */
	public byte[] privateDecrypt(byte[] data){
		getHandler();
		try {
			RSAPrivateKey privateKey = rsaHandler.getPrivateKey(key.getPrivateKey());
			return rsaHandler.privateDecrypt(data, privateKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 私钥加密
	 */
	public String privateEncrypt(String text){
		getHandler();
		try {
			RSAPrivateKey privateKey = rsaHandler.getPrivateKey(key.getPrivateKey());
			return rsaHandler.privateEncrypt(text, privateKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 私钥加密
	 */
	public byte[] privateEncrypt(byte[] data){
		getHandler();
		try {
			RSAPrivateKey privateKey = rsaHandler.getPrivateKey(key.getPrivateKey());
			return rsaHandler.privateEncrypt(data, privateKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 公钥解密
	 */
	public String publicDecrypt(String passWord){
		getHandler();
		try {
			RSAPublicKey publicKey = rsaHandler.getPublicKey(key.getPublicKey());
			return rsaHandler.publicDecrypt(passWord, publicKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 公钥解密
	 */
	public byte[] publicDecrypt(byte[] data){
		getHandler();
		try {
			RSAPublicKey publicKey = rsaHandler.getPublicKey(key.getPublicKey());
			return rsaHandler.publicDecrypt(data, publicKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *	用私钥对信息生成数字签名
	 * @param data 加密数据
	 */
	public String sign(String data){
		getHandler();
		return rsaHandler.sign(data, key.getPrivateKey());
	}
	/**
	 *	用私钥对信息生成数字签名
	 * @param data 加密数据
	 */
	public byte[] sign(byte[] data){
		getHandler();
		return rsaHandler.sign(data, key.getPrivateKey());
	}
	/**
	 * 用公钥校验数字签名
	 * @param data 接收到的加密数据
	 * @param sign 接收到的数字签名
	 */
	public Boolean verify(String data,String sign){
		getHandler();
		return rsaHandler.verify(data, key.getPublicKey(), sign);
	}
	/**
	 * 用公钥校验数字签名
	 * @param data 接收到的加密数据
	 * @param sign 接收到的数字签名
	 */
	public Boolean verify(byte[] data,byte[] sign){
		getHandler();
		return rsaHandler.verify(data, key.getPublicKey(), Utils.toHexString(sign));
	}
}
