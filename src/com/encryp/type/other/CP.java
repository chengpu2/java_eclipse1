package com.encryp.type.other;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.encryp.handler.other.CPHandler;
import com.encryp.utils.annotations.CPStringEncrypFalg;
import com.encryp.utils.enums.CPEncrypMode;

public class CP{
	private static Map<Integer,int[]> map;
	private CPHandler cpHandler = null;
	private void getHandler(){
		if(cpHandler == null){
			cpHandler = new CPHandler();
		}
	}
	public String CPEncrypt(String text){
		getHandler();
		return cpHandler.innovate(null,cpHandler.Base64(null,text));
		//return cpHandler.Base64(null,cpHandler.innovate(null,text));
	}
	public String CPDecrypt(String passWord){
		getHandler();
		return cpHandler.Base64Decrypt(null,cpHandler.innovate(null,passWord));
		//return cpHandler.innovate(null,cpHandler.Base64Decrypt(null,passWord));
	}
	public String CPEncrypt(String salt, String passWord){
		if(map == null){
			map = new HashMap<>();
			CPEncrypMode[] Array = CPEncrypMode.class.getEnumConstants();
			for(int i=0;i<Array.length;i++){
				map.put(i, Array[i].getMode());
			}
		}
		getHandler();
		String userMd5 = cpHandler.MD5(salt, passWord);
		int mode = 0;
		for(int i=0,j=3;i<userMd5.length();i+=8,j--){
			int num = Integer.valueOf(userMd5.substring(i,i+1),16);
			if(num>=8){
				mode+=Math.pow(2, j);
			}
		}
		for(int i=0;i<userMd5.length();i+=4){
			int num = Integer.valueOf(userMd5.substring(i,i+1),16);
			if(num>=8){
				mode++;
			}
		}
		int [] order = map.get(mode);
		@SuppressWarnings("unchecked")
		Class<CPHandler> clazz = (Class<CPHandler>) cpHandler.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		Method[] methodsFalg = new Method[4];
		for (Method method : methods) {
			CPStringEncrypFalg annoTest = (CPStringEncrypFalg) method.getAnnotation(CPStringEncrypFalg.class);
			if(annoTest!=null){
				methodsFalg[annoTest.value()] = method;
			}
		}
		String s = salt;
		String pass = passWord;
		for(int i = 0;i<order.length;i++){
			try {
				pass = (String)methodsFalg[order[i]].invoke(cpHandler,s,pass);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return pass;
	}

}
