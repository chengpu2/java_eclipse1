package com.encryp.type.other;

import com.encryp.pojo.SymmetryKey;
import com.encryp.handler.other.HMACHandler;
public class HMAC{
	private SymmetryKey key;
	private HMACHandler hmacHandler = null;
	private void getHandler(){
		if(hmacHandler == null){
			hmacHandler = new HMACHandler();
		}
	}
	public SymmetryKey getKey() {
		return key;
	}
	/**
	 * 设置key，一般通过其他端获得,可能导致将原来key覆盖，不建议使用,请通过直接新建AES来设置
	 */
	@Deprecated
	public void setKey(String key) {
		this.key.setPublicKey(key);
	}
	/**
	 * 设置key，一般通过其他端获得,可能导致将原来key覆盖，不建议使用,请通过直接新建AES来设置
	 */
	@Deprecated
	public void setKey(SymmetryKey key) {
		this.key = key;
	}
	public HMAC(SymmetryKey key){
		this.key = key;
	}
	public HMAC(String key){
		this.key = new SymmetryKey(key);
	}
	public String Encrypt(String text){
		getHandler();
		return hmacHandler.HMAC(text, key.getPublicKey());
	}
	public byte[] Encrypt(byte[] data){
		getHandler();
		return hmacHandler.HMAC(data, key.getPublicKey());
	}
}
