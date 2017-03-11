/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nb
 */
public class CyberCommunicationCenter extends UnicastRemoteObject implements WebserverInterface {

    SecurityBureau cia;
    
    // Authenticate User
    
    // Download Data Dump
    
    // Stream Real Time Data
    SensorCommandCenter nsa;
    DataManipulationService db;
    
}
