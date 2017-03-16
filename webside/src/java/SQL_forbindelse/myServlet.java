/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
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
@WebServlet(name = "myServlet", urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myServlet at " + request.getContextPath() + "</h1>");
            out.println("Getting data from database");

            //  KontoI k =(KontoI) Naming.lookup("rmi://javabog.dk:20099/kontotjeneste");
            //System.setSecurityManager(new RMISecurityManager());
            ArrayList<String> data = null;
            // Amazon IP server: 52.56.199.233
            sql_interface db = (sql_interface) Naming.lookup("rmi://localhost:53067/WEB_SQL");

            if (request.getParameter("getSensordata") != null) {
                int SensorID = Integer.parseInt(request.getParameter("sensorID"));
                data = db.getAllBySensorID_RMI(1);

            } else if (request.getParameter("getLocationData") != null) {
                String temp = request.getParameter("location");
                data = db.getAllByLocation_RMI(temp);

            } else if (request.getParameter("getDateData") != null) {

            } else {
                // ???

            }
                out.println("<br>");
                for (String d : data) {
                    out.println(d + "<br>");
                    System.out.println(d);
                }
            out.println("<a href=\"index.html\">\n"
                    + "   <button> Home </button>\n"
                    + "</a>");

            out.println("<a href=\"requestData.jsp\">\n"
                    + "   <button> Back </button>\n"
                    + "</a>");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(myServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(myServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
