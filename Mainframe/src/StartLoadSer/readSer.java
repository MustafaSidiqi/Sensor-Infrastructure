/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartLoadSer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author taras
 */
public class readSer {

    /**
     * This is used to read Serialized Object and returnes this object
     * Object is used to translate data from int to string 
     * Object has 4 hash tables
     * @return
     *      
     */
    public static EnumSerialize readHash(){
        EnumSerialize hs = null;
        try {
            FileInputStream fileIn = new FileInputStream("hash.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            hs = (EnumSerialize) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {            
            return new EnumSerialize();
        } catch (ClassNotFoundException c) {
            System.out.println("EnumSerialize class not found");
            c.printStackTrace();
            return hs;
        }

        return hs;
    }
}
