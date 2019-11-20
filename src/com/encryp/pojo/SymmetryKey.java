package com.encryp.pojo;

import com.encryp.utils.interfaces.Key;

public class SymmetryKey implements Key{
	private String publicKey;
	@Override
	public String getPublicKey() {
		return publicKey;
	}

	@Override
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	
	public SymmetryKey(){}
	
	public SymmetryKey(String publicKey){
		this.publicKey = publicKey;
	}

}
