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

      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("        \n");
      out.write("            \n");
      out.write("                \n");
      out.write("                    \n");
      out.write("                        <!DOCTYPE html>\n");
      out.write("                        <html>\n");
      out.write("\n");
      out.write("                        <head>\n");
      out.write("                            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("                            <title>Request Data</title>\n");
      out.write("                            <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("                        </head>\n");
      out.write("\n");
      out.write("                        <body background=\"img/background.png\">\n");
      out.write("                            <ul class=\"nav\">\n");
      out.write("\n");
      out.write("                                <div class=\"login\">\n");
      out.write("                                    <a href=\"#\">LOGIN </a>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"logo\">\n");
      out.write("                                    <a href=\"#\">LOGO </a>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <li> <a href=\"index.html\"> Home </a></li>\n");
      out.write("                                <li> <a href=\"index.html\"> About </a></li>\n");
      out.write("                                <li> <a href=\"\"> Services </a></li>\n");
      out.write("                                <li> <a href=\"\"> Contact</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"heading\">Services </div>\n");
      out.write("                            <form action=\"myServlet\" method=\"POST\">\n");
      out.write("                                <table align=\"center\" border=\"0\" width=\"0\" cellspacing=\"4\" cellpadding=\"6\">\n");
      out.write("                                    <tbody class=\"table1\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Username: </td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td>Location:</td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>From: </td>\n");
      out.write("                                            <td><input type=\"date\" name=\"fromDate\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>To:</td>\n");
      out.write("                                            <td><input type=\"date\" name=\"toDate\"></td>\n");
      out.write("                                            <td><input type=\"submit\" value=\"Request\" name=\"getDateData\" /></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Location: </td>\n");
      out.write("                                            <td><select name=\"location\">\n");
      out.write("                                <option>Location</option>\n");
      out.write("                                <option value=\"Lyngby\">DTU Lyngby</option>\n");
      out.write("                                <option value=\"stue\">DTU Stue</option>\n");
      out.write("                            </td>\n");
      out.write("                            <td></select><input type=\"submit\" value=\"Request\" name=\"getLocationData\" /></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Sensor: </td>\n");
      out.write("                                            <td><select name=\"sensorID\">\n");
      out.write("                                <option>Sensor</option>\n");
      out.write("                                <option value =\"1\" >Temperature</option>\n");
      out.write("                                <option value =\"2\" >Noise Level</option>\n");
      out.write("                                <option value = \"3\" >Humidity</option>\n");
      out.write("                            </select>\n");
      out.write("\n");
      out.write("                                            </td>\n");
      out.write("                                            <td><input type=\"submit\" value=\"Request\" name=\"getSensordata\" /></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td> </td>\n");
      out.write("                                            <td> </td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td> <input type=\"reset\" value=\"Clear\" /></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                            <td></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </form>\n");
      out.write("                        </body>\n");
      out.write("\n");
      out.write("                        </html>");
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
