/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartLoadSer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author taras
 */
public class readSer {

    public static EnumSerialize readHash(){
        EnumSerialize hs = null;
        try {
            FileInputStream fileIn = new FileInputStream("hash.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            hs = (EnumSerialize) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            File f = new File("hash.ser");
            
            return new EnumSerialize();
        } catch (ClassNotFoundException c) {
            System.out.println("EnumSerialize class not found");
            c.printStackTrace();
            return null;
        }

        return hs;
    }
}
