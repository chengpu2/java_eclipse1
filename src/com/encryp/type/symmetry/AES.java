package com.encryp.type.symmetry;

import com.encryp.handler.symmetry.AESHandler;
import com.encryp.pojo.SymmetryKey;

public class AES {
	private SymmetryKey key;
	private AESHandler aesHandler = null;
	private void getHandler(){
		if(aesHandler == null){
			aesHandler = new AESHandler();
		}
	}
	/**
	 * 获取key，一般用于发送
	 */
	public SymmetryKey getKey() {
		return key;
	}
	/**
	 * 设置key，一般通过其他端获得,可能导致将原来key覆盖，不建议使用,请通过直接新建AES来设置
	 */
	@Deprecated
	public void setKey(SymmetryKey key) {
		this.key.setPublicKey(key.getPublicKey());
	}
	/**
	 * 设置key，一般通过其他端获得,可能导致将原来key覆盖，不建议使用,请通过直接新建AES来设置
	 */
	@Deprecated
	public void setKey(String key) {
		this.key.setPublicKey(key);
	}
	/**
	 * 新建AES加密对象，key从其他端获得
	 */
	public AES(SymmetryKey key){
		this.key = key;
	}
	public AES(String key){
		this.key = new SymmetryKey(key);
	}
	/**
	 * 加密
	 */
	public String Encrypt(String text){
		getHandler();
		return aesHandler.Encrypt(key.getPublicKey(), text);
	}
	/**
	 * 加密
	 */
	public byte[] Encrypt(byte[] data){
		getHandler();
		return aesHandler.Encrypt(key.getPublicKey(), data);
	}
	/**
	 * 解密
	 */
	public String Decrypt(String passWord){
		getHandler();
		return aesHandler.Decrypt(key.getPublicKey(), passWord);
	}
	/**
	 * 解密
	 */
	public byte[] Decrypt(byte[] data){
		getHandler();
		return aesHandler.Decrypt(key.getPublicKey(), data);
	}
}
