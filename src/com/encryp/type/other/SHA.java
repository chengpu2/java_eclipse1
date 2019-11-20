package com.encryp.type.other;
import com.encryp.handler.other.SHAHandler;
public class SHA{
	private SHAHandler shaHandler = null;
	private void getHandler(){
		if(shaHandler == null){
			shaHandler = new SHAHandler();
		}
	}
	public String Encryp(String text){
		getHandler();
		return shaHandler.SHA(null, text);
	}
	public byte[] Encryp(byte[] data){
		getHandler();
		return shaHandler.SHA(null, data);
	}
}
