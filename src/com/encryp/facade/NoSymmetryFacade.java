package com.encryp.facade;

import com.encryp.builder.onsymmetry.RSABuilder;
import com.encryp.pojo.NoSymmetryKey;
import com.encryp.type.nosymmetry.RSA;

public class NoSymmetryFacade {
	private RSABuilder rsaBuilder = null;
	private NoSymmetryFacade(){
		rsaBuilder = new RSABuilder();
	}
	//用静态内部类加载单例
	private static class NoSymmetryFacadeHolder{
		private static NoSymmetryFacade noSymmetryFacade = new NoSymmetryFacade();
	}
	/**
	 * 获取非对称加密门面对象
	 */
	public static NoSymmetryFacade getNoSymmetryFacade(){
		return NoSymmetryFacadeHolder.noSymmetryFacade;
	}
	/**
	 * 创建AES加密对象
	 */
	public RSA RESBuilder(){
		return rsaBuilder.Builder(1024);
	}
	/**
	 * 创建指定key长度的RSA加密对象，长度为2的次方且不小于512
	 */
	public RSA RESBuilder(int size){
		return rsaBuilder.Builder(size);
	}
}
