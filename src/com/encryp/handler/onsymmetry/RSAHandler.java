package com.encryp.handler.onsymmetry;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import com.encryp.utils.Utils;

public class RSAHandler {
    public static final String RSA_ALGORITHM = "RSA";

    /**
     * 得到公钥
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }
    
    /**
     * 得到私钥
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }
    
    /**
     * 公钥加密
     * @param data
     * @param publicKey
     * @return
     */
    public byte[] publicEncrypt(byte[] data, RSAPublicKey publicKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            //拆分加密再组合为Base64编码的安全密文，注意：Java 规定rsa加密明文不超过密钥长度（Bytes）减11，所以要拆分
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data, publicKey.getModulus().bitLength())).getBytes(Utils.EncrypCode);
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }
    public String publicEncrypt(String text, RSAPublicKey publicKey){
    	try {
			return new String(publicEncrypt(text.getBytes(Utils.EncrypCode),publicKey));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    /**
     * 私钥解密
     * @param data
     * @param privateKey
     * @return
     */

    public byte[] privateDecrypt(byte[] data, RSAPrivateKey privateKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            //拆分解密再组合为字符串
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), privateKey.getModulus().bitLength()), Utils.EncrypCode).getBytes(Utils.EncrypCode);
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }
    public String privateDecrypt(String passWord, RSAPrivateKey privateKey){
    	try {
			return new String(privateDecrypt(passWord.getBytes(Utils.EncrypCode),privateKey));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return null;
    }

    /**
     * 私钥加密
     * @param data
     * @param privateKey
     * @return
     */

    public byte[] privateEncrypt(byte[] data, RSAPrivateKey privateKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
          //拆分加密再组合为Base64编码的安全密文，注意：Java 规定rsa加密明文不超过密钥长度（Bytes）减11，所以要拆分
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data, privateKey.getModulus().bitLength())).getBytes(Utils.EncrypCode);
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }
    public String privateEncrypt(String text, RSAPrivateKey privateKey){
    	try {
			return new String(privateEncrypt(text.getBytes(Utils.EncrypCode),privateKey));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    /**
     * 公钥解密
     * @param data
     * @param publicKey
     * @return
     */

    public byte[] publicDecrypt(byte[] data, RSAPublicKey publicKey){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            //拆分解密再组合为字符串
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), Utils.EncrypCode).getBytes(Utils.EncrypCode);
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }
    public String publicDecrypt(String passWord, RSAPublicKey publicKey){
    	try {
			return new String(publicDecrypt(passWord.getBytes(Utils.EncrypCode),publicKey));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    @SuppressWarnings("deprecation")
	private byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize){
        int maxBlock = 0;
        //若为加密模式，
        if(opmode == Cipher.DECRYPT_MODE){
            maxBlock = keySize / 8;
        }else{
        	//解密模式，长度为密文长度-11
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try{
        	//拆分加密或解密
            while(datas.length > offSet){
                if(datas.length-offSet > maxBlock){
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                }else{
                	//最后一段
                    buff = cipher.doFinal(datas, offSet, datas.length-offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        }catch(Exception e){
            throw new RuntimeException("加解密阀值为["+maxBlock+"]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        IOUtils.closeQuietly(out);
        return resultDatas;
    }
    /**
	 *	用私钥对信息生成数字签名
	 * @param data	//加密数据
	 * @param privateKey	//私钥
	 * @return
	 * @throws Exception
	 */
	public byte[] sign(byte[] data,String key){
		try {
			RSAPrivateKey privateKey = getPrivateKey(key);
			//用私钥对信息生成数字签名
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initSign(privateKey);
			signature.update(data);
			return signature.sign();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *	用私钥对信息生成数字签名
	 * @param data	//加密数据
	 * @param privateKey	//私钥
	 * @return
	 * @throws Exception
	 */
	public String sign(String data,String key){
		try {
			RSAPrivateKey privateKey = getPrivateKey(key);
			//用私钥对信息生成数字签名
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initSign(privateKey);
			signature.update(data.getBytes(Utils.EncrypCode));
			return Utils.toHexString(signature.sign());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 校验数字签名
	 * @param data	加密数据
	 * @param publicKey	公钥
	 * @param sign	数字签名
	 * @return
	 * @throws Exception
	 */
	public Boolean verify(byte[] data,String publicKey,String sign){

		RSAPublicKey publicKey2;
		try {
			publicKey2 = getPublicKey(publicKey);
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initVerify(publicKey2);
			signature.update(data);
			//验证签名是否正常
			return signature.verify(Utils.toByteArray(sign));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	/**
	 * 校验数字签名
	 * @param data	加密数据
	 * @param publicKey	公钥
	 * @param sign	数字签名
	 * @return
	 * @throws Exception
	 */
	public Boolean verify(String data,String publicKey,String sign){
		RSAPublicKey publicKey2;
		try {
			publicKey2 = getPublicKey(publicKey);
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initVerify(publicKey2);
			signature.update(data.getBytes(Utils.EncrypCode));
			//验证签名是否正常
			return signature.verify(Utils.toByteArray(sign));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
}
