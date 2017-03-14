/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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

/**
 *
 * @author Mustafa Sidiqi
 */
@WebServlet(name = "loginRMI", urlPatterns = {"/loginRMI"})
public class loginRMI extends HttpServlet {

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
            throws ServletException, IOException, RemoteException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginRMI</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginRMI at " + request.getContextPath() + "</h1>");

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            out.println(username);
            out.println(password);

            boolean aktiv = false;
            //GalgelegI spil = null;
            out.println("test01");
            try {
                Registry registry = LocateRegistry.getRegistry("ubuntu4.javabog.dk", 53518);
                out.println("test02");
                GalgelegI spil = (GalgelegI) registry.lookup("GalgelegI:15351");
                out.println("test03");

                if (!aktiv) {
                    aktiv = spil.loggedIn(username, password);
                }
                //    spil.nulstil();
                spil.logStatus();

            } catch (MalformedURLException | NotBoundException | RemoteException e) {
                e.printStackTrace();
            }



            if (aktiv == true) {
                out.println("Welcome " + username + " <meta http-equiv=refresh content=10;URL=\"requestData.jsp\">");

            } else {
                out.println("You have entered a wrong username " + username + " <meta http-equiv=refresh content=5;URL=\"login.jsp\">");
                out.println("<br><br/> Redirecting...");
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
