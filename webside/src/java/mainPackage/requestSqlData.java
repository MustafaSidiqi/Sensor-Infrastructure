/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import SQL_forbindelse.DB;
import SQL_forbindelse.DataStruct;
import static StartLoadSer.readSer.readHash;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mustafa Sidiqi
 */
@WebServlet(name = "requestSqlData", urlPatterns = {"/requestSqlData"})
public class requestSqlData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> stuff;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet requestSqlData</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet requestSqlData at " + request.getContextPath() + "</h1>");
            /*
            String dateFrom = request.getParameter("fromDate");
            String dateTo = request.getParameter("toDate");
            String location = request.getParameter("location");
            String sensor = request.getParameter("sensor");
            String sensorID = request.getParameter("sensorID");
             */
 /*
            try {
                out.println("test01");

                sql_interface k = (sql_interface) Naming.lookup("rmi://localhost:5050/sql2");
                
                out.println("test02");
                stuff = k.getAllBySensorID_RMI(1);
                out.println("test03");
                for (String d : stuff) {
                    System.out.println(d);
                    out.println("This is stuff, much wow" + stuff);
                }
            } catch (NotBoundException ex) {
                Logger.getLogger(requestSqlData.class.getName()).log(Level.SEVERE, null, ex);
                out.println("test04");
            } catch (MalformedURLException ex) {
                Logger.getLogger(requestSqlData.class.getName()).log(Level.SEVERE, null, ex);
                out.println("test05");
            } catch (RemoteException ex) {
                Logger.getLogger(requestSqlData.class.getName()).log(Level.SEVERE, null, ex);
                out.println("test06");
            }

             */
            ArrayList<DataStruct> data;

            DB test;
            try {
                test = new DB("jdbc:mysql://sensordb.cfdquak6nbpb.eu-west-2.rds.amazonaws.com:3306/SensorDB", "sensorDatabase", "sensor2017", readHash());
                //test = new DB("jdbc:mysql://localhost:3306/sensor_test","root","");

                data = test.getAllBySensorID(1);
                data.forEach((d) -> {
                    out.println(d.objToString());
                });
            } catch (RemoteException ex) {
                out.println(ex.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
