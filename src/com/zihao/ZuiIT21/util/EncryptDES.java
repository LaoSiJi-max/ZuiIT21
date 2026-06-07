package com.zihao.ZuiIT21.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.SunJCE;

//DES加密的工具类
public class EncryptDES
{
	private KeyGenerator keyGenerator;
	private SecretKey secretKey;
	private Cipher cipher;
	
	public EncryptDES()
	{
		try 
		{
			Security.addProvider(new SunJCE());
			keyGenerator = KeyGenerator.getInstance("DES");
			secretKey  = new SecretKeySpec("11111111".getBytes(), "DES");
			cipher = Cipher.getInstance("DES");
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			e.printStackTrace();
		}
	}
	
	public String encrytor(String text)
	{
		try
		{
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] textByte = text.getBytes();
			byte[] enTextByte = cipher.doFinal(textByte);
			String enText = new String(enTextByte);
			
			return enText;
		}
		catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String decryptor(String enText)
	{
		try
		{
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			if(enText==null)
			{
				enText = "";
			}
			byte[] enTextByte = enText.getBytes();
			byte[] textByte = cipher.doFinal(enTextByte);
			String text = new String(textByte);
			
			return text;
		}
		catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
