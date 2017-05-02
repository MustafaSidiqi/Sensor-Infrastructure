/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsystem;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author triblex
 */
public class Crypt {

    public byte[] encrypt(String plainText, String encryptionKey, String IV) throws Exception {

       
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    
        cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    
        return cipher.doFinal(plainText.getBytes("UTF-8"));
  
    }

  
    public String decrypt(byte[] cipherText, String encryptionKey, String IV) throws Exception{
    
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    
        cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    
        return new String(cipher.doFinal(cipherText),"UTF-8");
  
    }
}
