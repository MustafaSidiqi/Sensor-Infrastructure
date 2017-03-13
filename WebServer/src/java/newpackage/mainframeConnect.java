/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Mustafa
 */
@WebServlet(name = "mainframeConnect", urlPatterns = {"/mainframeConnect"})
public class mainframeConnect extends HttpServlet {

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
            throws ServletException, IOException, RemoteException, NotBoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String un = request.getParameter("username");
            String pw = request.getParameter("password");
            boolean validUser = false;
            //WebserverInterface WSI;

            GalgelegI spil = null;
            boolean aktiv = false;
            try {
                Registry registry = LocateRegistry.getRegistry("ubuntu4.javabog.dk", 53518);
                spil = (GalgelegI) registry.lookup("GalgelegI15351");
                //    spil.nulstil();
                spil.logStatus();
            } catch (Exception e) {
                e.printStackTrace();
            }

            /*
            try {
                System.setSecurityManager(new RMISecurityManager());
                WSI = (WebserverInterface) Naming.lookup("rmi://localhost:1337/cybercommunicationscenter");
                validUser = WSI.cyberLogin(un, pw);
                System.out.println("Connected");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("HelloClient exception: " + e);
            }
             */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mainframeConnect</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mainframeConnect at " + request.getContextPath() + "</h1>");

            //validUser = spil.loggedIn(un, pw);
            System.out.println(aktiv);

            out.println("This is aktiv " + aktiv);
            System.out.println(aktiv);
            /*
            if (validUser == true) {
                out.println("Welcome " + un + " <meta http-equiv=refresh content=2;URL=\"requestData.jsp\">");
            } else {
                out.println("You have entered a wrong username " + un + " <meta http-equiv=refresh content=5;URL=\"login.jsp\">");
                out.println("<br><br/> Redirecting...");
            }
             */
            if (!aktiv) {
                aktiv = spil.loggedIn("jacno", "xxx");
            }
            if (aktiv == true) {
                out.println("Welcome " + un + " <meta http-equiv=refresh content=2;URL=\"requestData.jsp\">");

            } else {
                out.println("You have entered a wrong username " + un + " <meta http-equiv=refresh content=5;URL=\"login.jsp\">");
                out.println("<br><br/> Redirecting...");
            }

            out.println("This is vailduser" + validUser);
            out.println("</body>");
            out.println("</html>");

        }
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestedSensor = request.getParameter("Sensor");
        String requesteddataFrom = request.getParameter("dataFrom");
        String requesteddataTo = request.getParameter("dataTo");
        
        System.out.println(requestedSensor);
        System.out.println(requesteddataFrom);
        System.out.println(requesteddataTo);

    }
}

     */
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
            throws ServletException, IOException, RemoteException {
        try {
            processRequest(request, response);
        } catch (NotBoundException ex) {
            Logger.getLogger(mainframeConnect.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (RemoteException ex) {
            Logger.getLogger(mainframeConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(mainframeConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("sd");

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
