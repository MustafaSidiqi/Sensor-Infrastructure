package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.ws.Service;
import javax.xml.namespace.QName;
import javax.xml.namespace.QName;
import java.net.URL;

public final class requestData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>User Login page</title>\r\n");
      out.write("                <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"logo\">\r\n");
      out.write("                <a href=\"#\">LOGO </a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <li> <a href=\"index.html\"> Home </a></li>\r\n");
      out.write("            <li> <a href=\"index.html\"> About </a></li>\r\n");
      out.write("            <li> <a href=\"\"> Services </a></li>\r\n");
      out.write("            <li> <a href=\"\"> Contact</a></li>\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"banner\">\r\n");
      out.write("            <img class=\"banner-image\" src=\"img/mountain.jpg\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h1>Request data from database:</h1>\r\n");
      out.write("        <form action=\"myServlet\" method=\"POST\">\r\n");
      out.write("\r\n");
      out.write("            <table border=\"0\" width=\"3\" cellspacing=\"4\" cellpadding=\"6\">\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Username: </td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td>Location:</td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>From: </td>\r\n");
      out.write("                        <td><input type=\"date\" name=\"fromDate\">    \r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>To:</td>\r\n");
      out.write("                        <td><input type=\"date\" name=\"toDate\"></td>\r\n");
      out.write("                        <td><input type=\"submit\" value=\"Request\" name=\"getDateData\" /></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Location: </td>\r\n");
      out.write("                        <td><select name=\"location\">\r\n");
      out.write("                                <option>Location</option>\r\n");
      out.write("                                <option value=\"Lyngby\">DTU Lyngby</option>\r\n");
      out.write("                                <option value=\"stue\">DTU stue</option>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td></select><input type=\"submit\" value=\"Request\" name=\"getLocationData\" /></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Sensor: </td>\r\n");
      out.write("                        <td><select name=\"sensorID\">\r\n");
      out.write("                                <option>Sensor</option>\r\n");
      out.write("                                <option value =\"1\" >Temperature</option>\r\n");
      out.write("                                <option value =\"2\" >Noise Level</option>\r\n");
      out.write("                                <option value = \"3\" >Humidity</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td><input type=\"submit\" value=\"Request\" name=\"getSensordata\" /></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>  </td>\r\n");
      out.write("                        <td>   </td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>    <input type=\"reset\" value=\"Clear\" /></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
