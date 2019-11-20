package com.encryp.type.other;

import com.encryp.handler.other.Base64Handler;

public class Base64{
	private Base64Handler base64Handler = null;
	private void getHandler(){
		if(base64Handler == null){
			base64Handler = new Base64Handler();
		}
	}
	public String Encryp(String text){
		getHandler();
		return base64Handler.Base64(null, text);
	}
	public byte[] Encryp(byte[] data){
		getHandler();
		return base64Handler.Base64(null, data);
	}
	public String Base64Decrypt(String passWord){
		getHandler();
		return base64Handler.Base64Decrypt(null, passWord);
	}
	public byte[] Base64Decrypt(byte[] data){
		getHandler();
		return base64Handler.Base64Decrypt(null, data);
	}
}
