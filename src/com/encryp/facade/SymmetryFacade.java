package com.encryp.facade;

import com.encryp.builder.symmetry.AESBuilder;
import com.encryp.pojo.SymmetryKey;
import com.encryp.type.symmetry.AES;

public class SymmetryFacade {
	private AESBuilder aesBuilder = null;
	private SymmetryFacade(){
		aesBuilder = new AESBuilder();
	}
	//用静态内部类加载单例
	private static class SymmetryFacadeHolder{
		private static SymmetryFacade symmetryFacade = new SymmetryFacade();
	}
	/**
	 * 获取对称加密门面对象
	 */
	public static SymmetryFacade getSymmetryFacade(){
		return SymmetryFacadeHolder.symmetryFacade;
	}
	/**
	 * 创建AES加密对象
	 */
	public AES AESBuilder(){
		return aesBuilder.Builder(null);
	}
	/**
	 * 创建按指key生成密钥的AES加密对象
	 */
	public AES AESBuilder(String createString){
		return aesBuilder.Builder(new SymmetryKey(createString));
	}
	/**
	 * 创建创建按指定key生成密钥的AES加密对象
	 */
	public AES AESBuilder(SymmetryKey createString){
		return aesBuilder.Builder(createString);
	}
}
