package com.encryp.facade;

import com.encryp.builder.other.HMACBuilder;
import com.encryp.pojo.SymmetryKey;
import com.encryp.type.other.*;

public class OtherFacade {
	private CP cp = null;
	private MD5 md5 = null;
	private SHA sha = null;
	private Base64 base64 = null;
	private HMACBuilder hmacBuilder= null;
	
	private OtherFacade(){
		cp = new CP();
		md5 = new MD5();
		sha = new SHA();
		base64 = new Base64();
		hmacBuilder = new HMACBuilder();
		
	}
	//用静态内部类加载单例
	private static class OtherFacadeHolder{
		private static OtherFacade otherFacade = new OtherFacade();
	}
	/**
	 * 创建其他加密门面对象
	 */
	public static OtherFacade getOtherFacade(){
		return OtherFacadeHolder.otherFacade;
	}
	/**
	 * CP加密,先Base64，再进行自创加密算法加密
	 */
	public String CP(String text){
		return cp.CPEncrypt(text);
	}
	/**
	 * CP解密
	 */
	public String CPDecrypt(String passWord){
		return cp.CPDecrypt(passWord);
	}
	/**
	 * CP加密，为自创加盐值的Hash加密
	 */
	public String CP(String salt, String passWord){
		return cp.CPEncrypt(salt, passWord);
	}
	/**
	 * MD5加密
	 */
	public String MD5(String text){
		return md5.Encryp(text);
	}
	/**
	 * MD5加密
	 */
	public byte[] MD5(byte[] data){
		return md5.Encryp(data);
	}
	/**
	 * Base64加密
	 */
	public String Base64(String text){
		return base64.Encryp(text);
	}
	/**
	 * Base64加密
	 */
	public byte[] Base64(byte[] data){
		return base64.Encryp(data);
	}
	/**
	 * Base64解密
	 */
	public String Base64Decrypt(String passWord){
		return base64.Base64Decrypt(passWord);
	}
	/**
	 * Base64解密
	 */
	public byte[] Base64Decrypt(byte[] data){
		return base64.Base64Decrypt(data);
	}
	/**
	 * SHA加密
	 */
	public String SHA(String text){
		return sha.Encryp(text);
	}
	/**
	 * SHA加密
	 */
	public byte[] SHA(byte[] data){
		return sha.Encryp(data);
	}
	/**
	 * 创建HMAC加密对象
	 */
	public HMAC HMACBuilder(){
		return hmacBuilder.Builder(null);
	}
	/**
	 * 创建创建按指定字符串生成密钥的HMAC加密对象
	 */
	public HMAC HMACBuilder(String key){
		return hmacBuilder.Builder(new SymmetryKey(key));
	}
	/**
	 * 创建创建按指定字符串生成密钥的HMAC加密对象
	 */
	public HMAC HMACBuilder(SymmetryKey key){
		return hmacBuilder.Builder(key);
	}
}
