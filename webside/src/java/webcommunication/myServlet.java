/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcommunication;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
            out.println("<br/>" + "Getting data from database");
            /*
            if (request.getParameter("database") != null) {
                databaseSelection = (String) request.getParameter("database");
                out.println("databaseSelection");
                out.println(databaseSelection);
            } else {
                out.println("Select a database");
            }
             */
            //  KontoI k =(KontoI) Naming.lookup("rmi://javabog.dk:20099/kontotjeneste");
            //System.setSecurityManager(new RMISecurityManager());
            ArrayList<String> data = null;
            // Amazon IP server: 52.56.199.233

            WebInterface db = (WebInterface) Naming.lookup("rmi://localhost:53168/data");
            out.println(db.getMessage());

            if (request.getParameter("SensorByIDdatabase") != null && request.getParameter("sensorID") != null) {
                int SensorID = Integer.parseInt(request.getParameter("sensorID"));
                out.println(SensorID);
                String databaseSelection = (String) request.getParameter("SensorByIDdatabase");

                ArrayList<String> temp = db.CallgetAllBySensorID(databaseSelection, SensorID);
                for (String object : temp) {
                    out.println("<br>");
                    out.println(object);
                }
                request.setAttribute("list", temp); //categorylist is an arraylist      contains object of class category  
                ServletContext context = getServletContext();
                RequestDispatcher rd = request.getRequestDispatcher("displayData.jsp");
                rd.forward(request, response);

            } else if (request.getParameter("SensorByDatedatabase") != null && request.getParameter("SensorByDatesensorID") != null) {
                int SensorID = Integer.parseInt(request.getParameter("SensorByDatesensorID"));
                String databaseSelection = request.getParameter("SensorByDatedatabase");
                String fromDate = request.getParameter("SensorByDateFrom");
                String toDate = request.getParameter("SensorByDateTo");

                /*
                DateFormat formatter;
                formatter = new SimpleDateFormat("MM-dd-yyyy");
                java.util.Date date =  formatter.parse(request.getParameter("SensorByDateFrom"));
                 */
                //Converting dates
                java.util.Date utilStartDate = new SimpleDateFormat("yyyy/MM/dd").parse(fromDate);
                java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

                java.util.Date utilStartDate2 = new SimpleDateFormat("yyyy/MM/dd").parse(toDate);
                java.sql.Date sqlEndDate = new java.sql.Date(utilStartDate.getTime());

                //Sending request for data
                ArrayList<String> temp = db.CallgetIntervalBySensorID("", 0, sqlStartDate, sqlEndDate);

                out.println("databaseSelection " + databaseSelection + "Form " + sqlStartDate + "to " + sqlEndDate);

                request.setAttribute("list", temp); //categorylist is an arraylist      contains object of class category  
                ServletContext context = getServletContext();
                RequestDispatcher rd = request.getRequestDispatcher("displayData.jsp");
                rd.forward(request, response);

            } else if (request.getParameter("LocationByIDdatabase") != null && request.getParameter("LocationByIDLocationID") != null) {
                String LocationID = (String) request.getParameter("LocationByIDLocationID");
                out.println(LocationID);
                String databaseSelection = (String) request.getParameter("LocationByIDdatabase");
                out.println(databaseSelection);

                ArrayList<String> temp = db.CallgetAllByLocation(databaseSelection, LocationID);
                for (String object : temp) {
                    out.println("<br>");
                    out.println(object);
                }
                request.setAttribute("list", temp); //categorylist is an arraylist      contains object of class category  
                ServletContext context = getServletContext();
                RequestDispatcher rd = request.getRequestDispatcher("displayData.jsp");
                rd.forward(request, response);
            } else if (request.getParameter("TypeByIDdatabase") != null && request.getParameter("TypeByIDID") != null) {
                int TypeID = Integer.parseInt(request.getParameter("TypeByIDID"));
                out.println(TypeID);
                String databaseSelection = (String) request.getParameter("TypeByIDdatabase");
                out.println(databaseSelection);

                ArrayList<String> temp = db.CallgetAllByType(databaseSelection, TypeID);
                for (String object : temp) {
                    out.println("<br>");
                    out.println(object);
                }
                request.setAttribute("list", temp); //categorylist is an arraylist      contains object of class category  
                ServletContext context = getServletContext();
                RequestDispatcher rd = request.getRequestDispatcher("displayData.jsp");
                rd.forward(request, response);
            } else {

            }
            /*
            out.println("<a href=\"index.html\">\n"
                    + "   <button> Home </button>\n"
                    + "</a>");

            out.println("<a href=\"requestData.jsp\">\n"
                    + "   <button> Back </button>\n"
                    + "</a>");
             */
            out.println("<br>");
            out.println("Something Went Wrong.");
            out.println("<br>");
            out.println("Redirecting...");
            response.addHeader("REFRESH", "5;URL=index.html");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private static class myClass {

        private static void requestSensorData() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void method3() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void method2() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public myClass() {
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
