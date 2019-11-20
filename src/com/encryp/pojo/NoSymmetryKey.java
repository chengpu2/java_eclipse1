package com.encryp.pojo;

import com.encryp.utils.interfaces.Key;

public class NoSymmetryKey implements Key{
	private String publicKey;
	private String privateKey;
	@Override
	public String getPublicKey() {
		return publicKey;
	}

	@Override
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	
	public NoSymmetryKey(){}
	
	public NoSymmetryKey(String privateKey){
		this.privateKey = privateKey;
	}
	
	public NoSymmetryKey(String privateKey,String publicKey){
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}
}
