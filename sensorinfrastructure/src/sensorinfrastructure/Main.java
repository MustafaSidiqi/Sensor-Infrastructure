/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorinfrastructure;

import SensorDataType.SensorDataType;
import datasystem.DataCollector;
import datasystem.DataControl;
import datasystem.SensorControl;
import datasystem.UserControl;
import sensorsystem.SensorSystem;
import securitysystem.UserAuthentication;
import ui.UserInterface;
import webcommunication.WebCommunication;

/**
 *
 * @author nb
 */
public class Main {

    
    // User Interface
    public static UserInterface ui;

    // User Javabog.dk user authentication
    public static UserAuthentication sec;
    
    // Sensor Functions given the to docking system
    public static SensorSystem sensorsystem;
    
    // Communication to the website
    public static WebCommunication web;
    
    // Data, user and sensors database controllers
    public static DataControl offdata;
    public static DataControl expdata;
    public static UserControl users;
    public static SensorControl sensors;
    
    public static DataCollector datacollect;
    
    // Main
    
    public static void main(String[] args) throws Exception {
        
        // Starting all systems
        
        System.out.println("Hello, World!\n\n");
        
        System.out.println("Launching User Interface.");
        
        ui = new UserInterface();
        
        System.out.println("Starting all systems...");
        
        
        // Javabog.dk User Authentication
        
        

        sec = new UserAuthentication();
        
        System.out.print("Trying to login to Javabog.dk...");
        
        if(sec.login("nibuh", "5;;+{Of)L#b[")) {
            
            System.out.println("Login succesful!");
        
        } else {
            
            System.out.print("Login not succesful.");
            
        }
        
        System.out.println("Connection to Javabog.dk established!\n\n");        
        


        // Databases
        
        System.out.println("Connecting to databases...");
        
        System.out.print("Official Sensor Database... ");
        
        offdata = new DataControl("offdata");
        
        System.out.print("Experimental Sensor Database... ");
        
        expdata = new DataControl("expdata");
        
        System.out.print("User Database... ");
        
        users = new UserControl();

        System.out.print("Sensor Database... ");
        
        sensors = new SensorControl();
        
        System.out.println("All databases are connected to the system!\n\n");
        
        

        // Sensor System and Dock
        
        System.out.println("Starting Sensor System and Dock...");

        sensorsystem = new SensorSystem(ui, sec, offdata, expdata, users, sensors);

        sensorsystem.initialiseSensorDockingSystem();
        
        System.out.println("Sensor System and Docks are up and running!\n\n");
        
        
        // Data Collector
        
        System.out.print("Starting Data Collector Thread... ");
        
        datacollect = new DataCollector(offdata, expdata, sensors, users, sensorsystem);
        
        System.out.println("Thread started!");
        
        

        // Web
        
        web = new WebCommunication(ui, offdata, expdata);
        
        web.publish();
  

        // Test webconnection
        
        System.out.print("Testing Web Connection... ");
        
        System.out.println("Not tested!\n\n");
        
        //System.out.println("Connection established");
  
        

        // All systems are now running!
        
        System.out.println("All systems are running");
        
        
        
        // Stating Threads
        
        datacollect.start();
        
        

    }
    
    public static void update() {
        
        
    }
    
    public static void draw() {
        
        
    }
}