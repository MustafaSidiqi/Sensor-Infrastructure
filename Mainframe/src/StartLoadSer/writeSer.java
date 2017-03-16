/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartLoadSer;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author taras
 */
public class writeSer {
    /**
     * 
     * @param hs  this is object of tipe EnumSerialize used to stor 4 hash tables.
     * This is used to write to object file hash.ser 
     * hash.ser is used to translate data from int to string 
     */
    
    public static void writeS(EnumSerialize hs){       
    try {   
         FileOutputStream fileOut = new FileOutputStream("hash.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(hs);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
    }
}
