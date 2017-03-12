/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import java.sql.Timestamp;

/**
 *
 * @author taras
 */
public class test_sql {
    
    public static void main(String[] args){
    
        /*try {
            DB  test = new DB("aa1k9u56usyttan.cfdquak6nbpb.eu-west-2.rds.amazonaws.com:3306","distribuerede","systemer");
        } catch (Exception ex) {
            System.out.println("Nooooooo....");
        }*/
         DB  test;
                try {
        //DB  test = new DB("jdbc:mysql://aa1k9u56usyttan.cfdquak6nbpb.eu-west-2.rds.amazonaws.com:3306/ebdb","distribuerede","systemer");
        test = new DB("jdbc:mysql://localhost:3306/sensor_test","root","");
        Timestamp d = new Timestamp(2017,03,10,16,50,20,20);
        d.setMonth(d.getMonth()-1);
           d.setYear(d.getYear()-1900);
       test.insertData(1, "stue", 2, 3, 4,d , 25);
       
         } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
