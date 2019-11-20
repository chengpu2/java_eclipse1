package com.encryp.builder.symmetry;
import com.encryp.pojo.SymmetryKey;
import com.encryp.type.symmetry.AES;
import com.encryp.utils.Utils;
public class AESBuilder {
	private CreateAESKeyHandler createAESKeyHandler = null;
	public AES Builder(SymmetryKey createString){
		if(createAESKeyHandler == null){
			createAESKeyHandler = new CreateAESKeyHandler();
		}
		String publicKey = createString!=null?createString.getPublicKey():createAESKeyHandler.createKey(Utils.getRandomString(16,64));
		return new AES(new SymmetryKey(publicKey));
	}
}
