package com.encryp.facade;
/**
 * 
 * @author chengpu
 * email 1036561197@qq.com
 */
public class EncrypFacade {
	/**
	 * 创建其他加密门面对象
	 */
	public static OtherFacade getOtherFacade(){
		return OtherFacade.getOtherFacade();
	}
	/**
	 * 创建对称加密门面对象
	 */
	public static SymmetryFacade getSymmetryFacade(){
		return SymmetryFacade.getSymmetryFacade();
	}
	/**
	 * 创建非对称加密门面对象
	 */
	public static NoSymmetryFacade getNoSymmetryFacade(){
		return NoSymmetryFacade.getNoSymmetryFacade();
	}
}
