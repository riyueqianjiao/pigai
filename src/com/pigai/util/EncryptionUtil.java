package com.pigai.util;
import java.security.MessageDigest;
import java.security.SecureRandom;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 
 * @author ssl
 *
 */
public class EncryptionUtil
{
	private EncryptionUtil()
	{
		
	}
    /**
     *  对明文plainText进行5加密,返回加密后的32位字符；若加密失败，返回null
     * */
	  public static final String MD5(String plainText)
	  {
	    try 
	      {
	         byte[] btInput =plainText.getBytes("UTF8");
	         MessageDigest mdInst = MessageDigest.getInstance("MD5");
	         mdInst.update(btInput);
	         byte[] md = mdInst.digest();
	         StringBuffer sb = new StringBuffer();
	         for (int i = 0; i < md.length; i++) 
	         {
	           int val = ((int) md[i]) & 0xff;
	           if (val < 16)
	           sb.append("0");
	           sb.append(Integer.toHexString(val));
	         }
	         return sb.toString();
	      }
	      catch (Exception e) 
	      {
	    	  return null;            //加密失败,返回null
	      }
	  }
	  

      /**
       * 
       * 对给定的明文进行DES加密，返回BASE64编码的加密字符串,返回的字符串以UTF8编码;
       * 
       * plainText为UTF8编码的字符串;若发生异常，则返回null
       * password 长度为8的倍数
       */
      public static final String desEncryption(String plainText, String password) 
      {            
          try
          {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密，正式执行加密操作
            byte[] cipherBytes=cipher.doFinal(plainText.getBytes("UTF8"));
            BASE64Encoder base64en=new BASE64Encoder();
            return base64en.encode(cipherBytes);
          }
          catch(Throwable e)
          {
             e.printStackTrace();
             return null;
          }
        
      }
      
      /**
       * 对给定的密文进行DES解密，返回解密的字符串,返回的字符串以UTF8编码;
       * 若发生异常，则返回null
       * 
       */
      public  static final String desDecryption(String cipherText, String password)
      {
    	 try
		 {
    		  // DES算法要求有一个可信任的随机数源
              SecureRandom random = new SecureRandom();
              // 创建一个DESKeySpec对象
              DESKeySpec desKey = new DESKeySpec(password.getBytes());
              // 创建一个密匙工厂
              SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
              // 将DESKeySpec对象转换成SecretKey对象
              SecretKey securekey = keyFactory.generateSecret(desKey);
              // Cipher对象实际完成解密操作
              Cipher cipher = Cipher.getInstance("DES");
              // 用密匙初始化Cipher对象
              cipher.init(Cipher.DECRYPT_MODE, securekey, random);
              // 真正开始解密操作
              BASE64Decoder base64De=new BASE64Decoder();
              byte[] bytes=cipher.doFinal(base64De.decodeBuffer(cipherText));
              return new String(bytes,"UTF8");
		} 
    	catch (Exception e)
		{
    		 e.printStackTrace();
             return null;
		}
         
  }
}
