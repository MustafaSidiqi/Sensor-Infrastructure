/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorinfrastructure;

import datasystem.DataControl;
import datasystem.SensorControl;
import datasystem.UserControl;
import sensorsystem.SensorSystem;
import securitysystem.UserAuthentication;
import webcommunication.WebCommunication;

/**
 *
 * @author nb
 */
public class Main {

    
    // User Javabog.dk user authentication
    public static UserAuthentication sec;
    
    // Sensor Functions given the to docking system
    public static SensorSystem sensor;
    
    // Communication to the website
    public static WebCommunication web;
    
    // Data, user and sensors database controllers
    public static DataControl data;
    public static UserControl users;
    public static SensorControl sensors;
    
    // Main
    
    public static void main(String[] args) throws Exception {

        sec = new UserAuthentication();
        data = new DataControl();

        sensor = new SensorSystem(sec, data, users, sensors);

        sensor.initialiseSensorDockingSystem();
        
        //web = new WebCommunication(sec, data, users, sensors);
        
        System.out.println("All systems are running");

    }
    
    public static void update() {
        
        
    }
    
    public static void draw() {
        
        
    }
}