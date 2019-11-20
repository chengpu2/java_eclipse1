package com.encryp.builder.other;

import com.encryp.handler.other.MD5Handler;
import com.encryp.utils.Utils;
public class CreateHMACKeyHandler {
	private MD5Handler md5Handler = null;
	protected String createKey(){
		if(md5Handler == null){
			md5Handler = new MD5Handler();
		}
		return md5Handler.MD5(null,Utils.getRandomString(16,64));
	}
}
