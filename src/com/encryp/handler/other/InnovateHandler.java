package com.encryp.handler.other;

public class InnovateHandler {
	public String innovate(String userName,String passWord) { 
		if(userName == null){
			userName = "userName";
		}
		char[] a = passWord.toCharArray();   
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ userName.charAt(i%userName.length()));  
		}   
		return new String(a);      
	}
}
