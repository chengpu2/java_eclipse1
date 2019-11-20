package com.encryp.handler.other;
import com.encryp.utils.annotations.CPStringEncrypFalg;

public class CPHandler{
	private MD5Handler md5Handler = null;
	private Base64Handler base64Handler = null;
	private SHAHandler shaHandler = null;
	private InnovateHandler innovateHandler = null;
	/**
	 * MD5没有解密算法
	 * @param passWord 需要加密的密码
	 * @return MD5加密后密码
	 */
	@CPStringEncrypFalg(0)
	public String MD5(String userName,String passWord){
		if(md5Handler == null){
			md5Handler = new MD5Handler();
		}
		return md5Handler.MD5(userName, passWord);
	}

	/**
	 * 
	 * @param passWord 需要加密的密码
	 * @return Base64加密后密码
	 */
	@CPStringEncrypFalg(1)
	public String Base64(String userName,String passWord){
		if(base64Handler == null){
			base64Handler = new Base64Handler();
		}
		return base64Handler.Base64(userName, passWord);
	}
	
	public String Base64Decrypt(String userName,String passWord){
		if(base64Handler == null){
			base64Handler = new Base64Handler();
		}
		return base64Handler.Base64Decrypt(userName, passWord);
	}
	
	/**
	 * SHA没有解密算法
	 * @param passWord 需要加密的密码
	 * @return 加密后密码
	 */
	@CPStringEncrypFalg(2)
	public String SHA(String userName,String passWord){
		if(shaHandler == null){
			shaHandler = new SHAHandler();
		}
		return shaHandler.SHA(userName, passWord);
	}
	
	@CPStringEncrypFalg(3)
	public String innovate(String userName,String passWord) { 
		if(innovateHandler == null){
			innovateHandler = new InnovateHandler();
		}
		return innovateHandler.innovate(userName, passWord); 
	}
	
}

