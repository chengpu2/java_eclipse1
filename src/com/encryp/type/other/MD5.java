package com.encryp.type.other;
import com.encryp.handler.other.MD5Handler;
public class MD5{
	private MD5Handler md5Handler = null;
	private void getHandler(){
		if(md5Handler == null){
			md5Handler = new MD5Handler();
		}
	}
	public String Encryp(String text){
		getHandler();
		return md5Handler.MD5(null, text);
	}
	public byte[] Encryp(byte[] data){
		getHandler();
		return md5Handler.MD5(null, data);
	}
}
