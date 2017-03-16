/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartLoadSer;

import static StartLoadSer.writeSer.writeS;
import java.util.Hashtable;
/**
 *
 * @author taras
 */
public class EnumSerialize implements java.io.Serializable{
    
    public Hashtable<Integer, String> enumType_i;
    public Hashtable<String, Integer> enumType_s;
    public Hashtable<Integer, String> enumUnit_i;
    public Hashtable<String, Integer> enumUnit_s;
    private int lastTypeID;
    private int lastUnitID;
    /**
     * Creates new object with 4 hashtables and 2 int
     * Hash tables for translating data from int to string and back 
     * 
     */
    public EnumSerialize() {
        enumType_i = new Hashtable<>();
        enumType_s = new Hashtable<>();

        enumUnit_i = new Hashtable<>();
        enumUnit_s = new Hashtable<>();
        lastTypeID = 0;
        lastUnitID = 0;
    }
        
    /**
     * 
     * @param s String that has Sensor type
     * @return returns id for new Sensor type
     * 
     * This takes string and maps into integer
     * Used to translate int to Sensor type 
     */
    public int setNewType(String s) {
        int temp = lastTypeID;
        enumType_i.put(temp, s);
        enumType_s.put(s, temp);     
        lastTypeID++;   
        
        writeS(this);             
        System.out.println("next Tvalue "+lastTypeID+" this Tvalue "+temp);
        return temp;
    }
    
    /**
     * 
     * @param s String 
     * @return 
     * 
     * Sets new Unit gives id to a unit 
     */
    public int setNewUnit(String s) {
        int temp2 = lastUnitID;
        enumUnit_i.put(temp2, s);
        enumUnit_s.put(s, temp2);
        lastUnitID++;
        
        writeS(this);        
        System.out.println("next value "+lastTypeID+" this value "+temp2);        
        return temp2;
    }
}
