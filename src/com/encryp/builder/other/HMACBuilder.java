package com.encryp.builder.other;
import com.encryp.pojo.SymmetryKey;
import com.encryp.type.other.HMAC;
public class HMACBuilder {
	private CreateHMACKeyHandler createHMACKeyHandler = null;
	public HMAC Builder(SymmetryKey key){
		if(createHMACKeyHandler == null){
			createHMACKeyHandler = new CreateHMACKeyHandler();
		}
		String publicKey = key!=null?key.getPublicKey():createHMACKeyHandler.createKey();
		return new HMAC(new SymmetryKey(publicKey));
	}
}
