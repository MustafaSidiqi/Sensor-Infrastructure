/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorinfrastructure;

import java.io.IOException;

/**
 *
 * @author nb
 */
public class SensorInfrastructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        try { 
            Process process = Runtime.getRuntime().exec("wall Hej Jesper, hilsen Java Programmet.");
        } catch (IOException ex) {
        
        }
        
        System.out.println("End.");

    }
    
}
