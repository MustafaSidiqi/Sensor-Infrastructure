/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsystem;


/**
 *
 * @author triblex
 */
public class XORStrings {

    public String xorHex(String a, String b) {
        // TODO: Validation
        char[] chars = new char[a.length()];
        for (int i = 0; i < chars.length; i++) {
           chars[i] = (char)((Character.getNumericValue(a.charAt(i))+87)^(Character.getNumericValue(b.charAt(i))+87));
           
        }
        return new String(chars);
    }
    
        public String encode(String s, String key) {
        return new String(xorWithKey(s.getBytes(), key.getBytes()));
    }

    public String decode(String s, String key) {
        return new String(xorWithKey(s.getBytes(), key.getBytes()));
    }

    private byte[] xorWithKey(byte[] a, byte[] key) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ key[i % key.length]);
        }
        return out;
    }

}
