package com.encryp.builder.onsymmetry;
import java.util.Map;

import com.encryp.pojo.NoSymmetryKey;
import com.encryp.type.nosymmetry.RSA;
public class RSABuilder {
	private CreateRSAKeyHandler createRSAKeyHandler = null;
	public RSA Builder(int size){
		if(createRSAKeyHandler == null){
			createRSAKeyHandler = new CreateRSAKeyHandler();
		}
		Map<String, String> keyMap = createRSAKeyHandler.createKeys(size);
		String privateKey = keyMap.get("privateKey");
		String publicKey = keyMap.get("publicKey");
		NoSymmetryKey key = new NoSymmetryKey(privateKey,publicKey);
		return new RSA(key);
	}
}
